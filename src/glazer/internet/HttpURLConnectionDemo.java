package glazer.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionDemo {
	public static void main(String[] args) throws IOException {

		URL url = new URL("http://www.google.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// the url executes the request
		String line;
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}
}
