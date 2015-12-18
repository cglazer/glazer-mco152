package glazer.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
	// read one line and sends one line
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(52746);
		// we need to wait for income
		Socket socket = serverSocket.accept();
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String response = reader.readLine();
		System.out.println("RESPONSE ");
		System.out.println(response);
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write("HOW ARE YOU DOING?");
		out.flush();
		socket.close();
	}
}
