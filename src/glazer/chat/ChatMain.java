package glazer.chat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.eclipse.jetty.server.Server;

public class ChatMain extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Container container;
	private JPanel southPanel;
	private JScrollPane scroll;
	private JTextArea centerText;
	private JTextField southText;
	private JButton pressMe;
	private JLabel label;

	public ChatMain() {
		setTitle("Chat");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.container = getContentPane();
		this.container.setLayout(new BorderLayout());
		this.centerText = new JTextArea();
		this.container.add(centerText, BorderLayout.CENTER);
		this.southPanel = new JPanel();
		this.southPanel.setLayout(new BorderLayout());
		this.southText = new JTextField("Text");
		this.southPanel.add(southText, BorderLayout.CENTER);
		this.pressMe = new JButton("Press me");
		this.southPanel.add(this.pressMe, BorderLayout.EAST);
		this.container.add(southPanel, BorderLayout.SOUTH);
		this.scroll = new JScrollPane(centerText);
		this.centerText.add(label);
		Server server = new Server(8080);
		server.setHandler(new ChatP2PHandler(centerText));
		try {
			server.start();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		this.pressMe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// call the instructions screen

				HttpURLConnection connection;
				try {
					URL url = new URL("http://192.168.117.39:8080");
					connection = (HttpURLConnection) url.openConnection();
					connection.setDoOutput(true);
					OutputStream out = connection.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					writer.println(southText.getText());
					writer.flush();
					connection.getInputStream();
					southText.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}
}
