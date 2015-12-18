package glazer.weather;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WeatherFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon weatherIcon;
	private JTextField zipText;
	private JButton searchButton;
	private URL imageURL;
	private JLabel imageLabel;
	private Container container;
	private JLabel cityName;
	private JLabel temp;
	private JLabel shortDescription;
	private JLabel tempMin;
	private JLabel tempMax;
	private JLabel humidity;
	private JLabel windSpeed;
	private JLabel invalid;
	private Image img;
	private Image newimg;
	private JLabel text;
	private ImageIcon search;
	private JPanel listPane;

	public WeatherFrame() throws MalformedURLException {
		setTitle("JFrameDemo");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.listPane = new JPanel();
		this.container = getContentPane();
		this.searchButton = new JButton();
		this.search = new ImageIcon(this.getClass().getResource("search.png"));
		this.img = search.getImage();
		this.newimg = img.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		this.search = new ImageIcon(newimg);
		this.zipText = new JTextField("ENTER ZIP");
		this.invalid = new JLabel();
		this.text = new JLabel("1\n2\n3\n4");
		this.imageLabel = new JLabel();
		this.cityName = new JLabel();
		this.temp = new JLabel();
		this.shortDescription = new JLabel();
		this.tempMin = new JLabel();
		this.tempMax = new JLabel();
		this.humidity = new JLabel();
		this.windSpeed = new JLabel();
		SetComponents();
	}

	public void SetComponents() {
		this.listPane.setBackground(Color.LIGHT_GRAY);
		this.listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
		this.searchButton.setIcon(search);
		this.searchButton.setBounds(445, 0, 40, 40);
		this.zipText.setBounds(346, 0, 105, 40);
		this.zipText.setFont(new Font("SansSerif", Font.PLAIN, 20));
		this.zipText.setForeground(Color.blue);
		this.invalid.setBounds(220, 0, 100, 40);
		this.invalid.setForeground(Color.RED);
		this.text.setBounds(450, 450, 100, 100);
		this.cityName.setFont(new Font("Serif", Font.BOLD, 55));
		this.cityName.setForeground(Color.BLUE);
		this.temp.setForeground(Color.RED);
		this.temp.setFont(new Font("Serif", Font.BOLD, 100));
		addComponents();
	}

	public void addComponents() {
		/**
		 * try { this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new
		 * File("Sky-Blue-Sky.jpg")))));
		 * 
		 * } catch (IOException e) { } ;
		 */
		this.container.add(zipText);
		this.container.add(invalid);
		this.container.add(text);
		this.listPane.add(imageLabel, BorderLayout.WEST);
		this.listPane.add(cityName, BorderLayout.CENTER);
		this.listPane.add(temp, BorderLayout.CENTER);
		this.listPane.add(shortDescription, BorderLayout.CENTER);
		this.listPane.add(tempMin, BorderLayout.CENTER);
		this.listPane.add(tempMax, BorderLayout.CENTER);
		this.listPane.add(humidity, BorderLayout.CENTER);
		this.listPane.add(windSpeed, BorderLayout.CENTER);
		this.container.add(searchButton);
		this.container.add(listPane, BorderLayout.CENTER);
		this.searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// call the instructions screen
				container = getContentPane();
				WeatherThread thread = new WeatherThread(zipText.getText(), invalid, container, imageURL, weatherIcon,
						img, newimg, imageLabel, cityName, temp, shortDescription, tempMin, humidity, windSpeed);
				thread.start();
				// String zip = zipText.getText();

			}
		});

	}

}
