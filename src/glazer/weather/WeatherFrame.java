package glazer.weather;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.google.gson.Gson;

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
		this.newimg = img
				.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
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
		this.zipText.setBounds(346, 0, 100, 40);
		this.zipText.setFont(new Font("SansSerif", Font.PLAIN, 20));
		this.zipText.setForeground(Color.blue);
		this.invalid.setBounds(220, 0, 100, 40);
		this.invalid.setForeground(Color.RED);
		this.text.setBounds(450, 450, 100, 100);
		this.cityName.setFont(new Font("Serif", Font.BOLD, 55));
		this.temp.setForeground(Color.BLUE);
		this.temp.setFont(new Font("Serif", Font.BOLD, 100));
		addComponents();
	}

	public void addComponents() {
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

				String zip = zipText.getText();
				String regex = "\\d{5}";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(zip);
				if (matcher.matches()) {
					invalid.setText("");
					try {
						DisplayInfo(zip);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					invalid.setText("Invalid Zip Code");

				}

			}
		});

	}

	public void DisplayInfo(String zip) throws IOException {
		this.container = this.getContentPane();
		this.container.setLayout(null);
		StringBuilder zipBuilder = new StringBuilder();
		zipBuilder
				.append("http://api.openweathermap.org/data/2.5/weather?zip=");
		zipBuilder.append(zip);
		zipBuilder
				.append(",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");
		URL url = new URL(zipBuilder.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		// this will return for us a list of ufo sightings
		WeatherReport info = gson.fromJson(reader, WeatherReport.class);
		if (info.getMain() == null) {
			System.out.println("null");
			invalid.setText("Invalid Zip Code");
		} else {
			Weather[] weather = info.getWeather();
			StringBuilder pic = new StringBuilder();
			pic.append("http://openweathermap.org/img/w/");
			pic.append(weather[0].getIcon());
			pic.append(".png");
			this.imageURL = new URL(pic.toString());
			this.weatherIcon = new ImageIcon(imageURL);
			this.img = weatherIcon.getImage();
			this.newimg = img.getScaledInstance(75, 75,
					java.awt.Image.SCALE_SMOOTH);
			this.weatherIcon = new ImageIcon(newimg);
			this.imageLabel.setIcon(weatherIcon);
			this.cityName.setText(info.getName().toUpperCase());
			StringBuilder temps = new StringBuilder();
			temps.append(String.valueOf((int) info.getMain().getTemp()));
			temps.append("\u2109");
			this.temp.setText(temps.toString());
			this.shortDescription.setText(weather[0].getMain());
			StringBuilder minTemp = new StringBuilder();
			minTemp.append("L: ");
			minTemp.append(String.valueOf(info.getMain().getTemp_min()));
			minTemp.append("\u2109      / H: ");
			minTemp.append(String.valueOf(info.getMain().getTemp_max()));
			minTemp.append("\u2109");
			this.tempMin.setText(minTemp.toString());
			StringBuilder humid = new StringBuilder();
			humid.append("Humidity:           ");
			humid.append(String.valueOf(info.getMain().getHumidity()));
			humid.append("%");
			this.humidity.setText(humid.toString());
			StringBuilder wind = new StringBuilder();
			wind.append("Wind Speed:     ");
			wind.append(String.valueOf(info.getWind().getSpeed()));
			wind.append(" MPH");
			this.windSpeed.setText(wind.toString());
		}
		repaint();
	}
}
