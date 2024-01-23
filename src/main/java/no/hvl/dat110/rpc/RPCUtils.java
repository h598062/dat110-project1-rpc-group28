package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

/**
 *
 */
public class RPCUtils {

	/**
	 * @param rpcid
	 * @param payload
	 * @return
	 */
	public static byte[] encapsulate(byte rpcid, byte[] payload) {

		byte[] rpcmsg = null;

		// TODO - START

		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END

		return rpcmsg;
	}

	/**
	 * @param rpcmsg
	 * @return
	 */
	public static byte[] decapsulate(byte[] rpcmsg) {

		byte[] payload = null;

		// TODO - START

		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END

		return payload;

	}

	/**
	 * convert String to byte array
	 *
	 * @param str
	 * @return
	 */
	public static byte[] marshallString(String str) {

		byte[] encoded = null;

		// TODO - START 

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END

		return encoded;
	}

	/**
	 * convert byte array to a String
	 *
	 * @param data
	 * @return
	 */
	public static String unmarshallString(byte[] data) {

		String decoded = null;

		// TODO - START 

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END

		return decoded;
	}

	/**
	 * @return
	 */
	public static byte[] marshallVoid() {

		byte[] encoded = null;

		// TODO - START 

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END

		return encoded;

	}

	/**
	 * @param data
	 */
	public static void unmarshallVoid(byte[] data) {

		// TODO

		if (true)
			throw new UnsupportedOperationException(TODO.method());

	}

	/**
	 * convert boolean to a byte array representation
	 *
	 * @param b
	 * @return
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
	 * @param data
	 * @return
	 */
	public static boolean unmarshallBoolean(byte[] data) {

		return (data[0] > 0);

	}

	/**
	 * integer to byte array representation
	 *
	 * @param x
	 * @return
	 */
	public static byte[] marshallInteger(int x) {

		byte[] encoded = null;

		// TODO - START 

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END

		return encoded;
	}

	/**
	 * byte array representation to integer
	 *
	 * @param data
	 * @return
	 */
	public static int unmarshallInteger(byte[] data) {

		int decoded = 0;

		// TODO - START 

		if (true)
			throw new UnsupportedOperationException(TODO.method());

		// TODO - END

		return decoded;

	}
}
