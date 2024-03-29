package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.util.Arrays;

import no.hvl.dat110.TODO;

/**
 *
 */
public class RPCUtils {

	/**
	 * @param rpcid   - ID til metode som skal kjøre ved hjelp av RPC
	 * @param payload - Byte[] med data
	 *
	 * @return rpcmsg - Payload med RPCID før payload
	 */
	public static byte[] encapsulate(byte rpcid, byte[] payload) {

		byte[] rpcmsg = new byte[payload.length + 1];
		rpcmsg[0] = rpcid;

		for (int i = 1; i < rpcmsg.length; i++) {
			rpcmsg[i] = payload[i - 1];
		}
		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format

		return rpcmsg;
	}

	/**
	 * @param rpcmsg
	 *
	 * @return
	 */
	public static byte[] decapsulate(byte[] rpcmsg) {
		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
		byte rpcid = rpcmsg[0];
		byte[] payload = new byte[rpcmsg.length - 1];

		for (int i = 1; i < rpcmsg.length; i++) {
			payload[i - 1] = rpcmsg[i];
		}

		return payload;
	}

	/**
	 * convert String to byte array
	 *
	 * @param str Stringen som skal marshalles
	 *
	 * @return En marshalled byte array representasjon av den gitte Stringen
	 */
	public static byte[] marshallString(String str) {

		byte[] encoded = str.getBytes();

		if (encoded.length > 127) {
			throw new InvalidParameterException("Tekststreng må passe inn i en 127 byte melding");
		}

		return encoded;
	}

	/**
	 * convert byte array to a String
	 *
	 * @param data En marshalled byte array representasjon av en String
	 *
	 * @return Stringen som er lagret i den oppgitte byte arrayen
	 */
	public static String unmarshallString(byte[] data) {
		StringBuilder sb = new StringBuilder();
		for (byte b : data) {
			sb.append((char) b);
		}
		return sb.toString();
	}

	/**
	 * Marshaller en void type, vi har bestemt at byte 99 representerer void
	 *
	 * @return en byte array som kun inneholder byte 99
	 */
	public static byte[] marshallVoid() {

		byte[] encoded = new byte[1];

		encoded[0] = 99;

		return encoded;
	}

	/**
	 * Unmarshaller en void type, vi har bestemt at byte 99 er void
	 *
	 * @param data Marshalled byte array som skal inneholde kun byte 99
	 */
	public static void unmarshallVoid(byte[] data) {
		if (data[0] != 99) {
			throw new InvalidParameterException("Void type må være 99");
		}
	}

	/**
	 * convert boolean to a byte array representation
	 *
	 * @param b Boolean som skal marshalles
	 *
	 * @return En marshalled byte array representasjon av den gitte boolean
	 */
	public static byte[] marshallBoolean(boolean b) {

		byte[] encoded = new byte[1];

		if (b) {
			encoded[0] = 1;
		} else {
			encoded[0] = 0;
		}

		return encoded;
	}

	/**
	 * convert byte array to a boolean representation
	 *
	 * @param data En marshalled byte array representasjon av en boolean
	 *
	 * @return Boolean som er lagret i den oppgitte byte arrayen
	 */
	public static boolean unmarshallBoolean(byte[] data) {
		return (data[0] > 0);
	}

	/**
	 * integer to byte array representation
	 *
	 * @param x Integer som skal marshalles
	 *
	 * @return En marshalled byte array representasjon av den gitte integeren
	 */
	public static byte[] marshallInteger(int x) {
		byte[] encoded = new byte[4];
		ByteBuffer b = ByteBuffer.wrap(encoded);
		b.putInt(x);
		return b.array();
	}

	/**
	 * byte array representation to integer
	 *
	 * @param data En marshalled byte array representasjon av en integer
	 *
	 * @return Integeren som er lagret i den oppgitte byte arrayen
	 */
	public static int unmarshallInteger(byte[] data) {
		ByteBuffer b = ByteBuffer.wrap(data);
		return b.getInt();
	}
}
