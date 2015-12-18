package glazer.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//client sends message and reads one line response
public class SocketClientDemo {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String serverIp = "192.168.117.39";// entered the client's ip address
		Socket socket = new Socket(serverIp, 52746);// we made up a port number

		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write("HI THERE!\n");
		out.flush();// don't forget this line!

		// we read a response with an inputStream
		// socket.getInputStream();
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String response = reader.readLine();
		System.out.println("RESPONSE ");
		System.out.println(response);
		socket.close();
	}
}
