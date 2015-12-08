package glazer.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketHttpRequestDemo {
	// we throw the exception in case no internet connection or invalid info is
	// given
	public static void main(String[] args) throws UnknownHostException, IOException {
		// we pass in the host name and the port number
		// 80 is the http port.
		Socket socket = new Socket("www.google.com", 80);
		String httpRequestString = "GET /index.html\n\n";
		// the above request is what's sent if you type ww.google.com and press
		// enter**
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write(httpRequestString);
		out.flush();// don't forget this line!

		// we read a response with an inputStream
		// socket.getInputStream();
		String line = "";

		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		socket.close();
	}
}
