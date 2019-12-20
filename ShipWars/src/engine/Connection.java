package engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {
	private static ServerSocket server;
	private static Socket client;
	private static PrintWriter out;
	private static BufferedReader in;

	public static void host(int port) throws IOException {
		if (in == null) {
			System.out.println("YEET!!!!");
			server = new ServerSocket(port);
			System.out.println("1");
			client = server.accept();
			System.out.println("2");
			out = new PrintWriter(client.getOutputStream(), true);
			System.out.println("3");
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			System.out.println("4");
		}
	}

	public static void connect(String ip, int port) throws IOException {
		if (in == null) {
			System.out.println("YEET!!!!");
			client = new Socket(ip, port);
			out = new PrintWriter(client.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		}
	}

	public static String input() throws IOException {
		if (in != null) {
			String input = "";
			input = in.readLine();
			return input;
		} else
			return null;
	}

	public static void output(String output) {

		if (!output.equals("") && out != null) {
			out.println(output);
		}

	}
}