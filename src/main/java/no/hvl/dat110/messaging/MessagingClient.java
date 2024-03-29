package no.hvl.dat110.messaging;


import java.io.IOException;
import java.net.Socket;

import no.hvl.dat110.TODO;

/**
 *
 */
public class MessagingClient {

	/**
	 * name/IP address of the messaging server
	 */
	private String server;

	/**
	 * server port on which the messaging server is listening
	 */
	private int port;

	/**
	 *
	 * @param server
	 * @param port
	 */
	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}

	/**
	 * setup of a messaging connection to a messaging server
	 * @return The MessageConnection to the server
	 */
	public MessageConnection connect()
	throws IOException {

		// client-side socket for underlying TCP connection to messaging server
		Socket clientSocket = new Socket(server, port);

		return new MessageConnection(clientSocket);
	}
}
