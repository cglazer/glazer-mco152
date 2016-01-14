package glazer.twitter;

import org.eclipse.jetty.server.Server;

public class TwitterJettyServer {
	public static void main(String[] args) throws Exception {
		// http://localhost:8080/
		// or type your friends address 192.168.117.59.8080 and you will see the
		// message you fried coded
		Server server = new Server(8080);
		server.setHandler(new TwitterHandler());

		server.start();
		server.join();
	}
}
