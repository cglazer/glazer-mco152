package glazer.weather;

import java.awt.Container;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.google.gson.Gson;

public class WeatherThread extends Thread {
	private String zip;
	private JLabel invalid;
	private Container container;
	private URL imageURL;
	private ImageIcon weatherIcon;
	private Image img;
	private Image newimg;
	private JLabel imageLabel;
	private JLabel cityName;
	private JLabel temp;
	private JLabel shortDescription;
	private JLabel tempMin;
	private JLabel humidity;
	private JLabel windSpeed;

	public WeatherThread(String zipText, JLabel invalid, Container container, URL imageURL, ImageIcon weatherIcon,
			Image img, Image newimg, JLabel imageLabel, JLabel cityName, JLabel temp, JLabel shortDescription,
			JLabel tempMin, JLabel humidity, JLabel windSpeed) {
		this.zip = zipText;
		this.invalid = invalid;
		this.container = container;
		this.imageURL = imageURL;
		this.weatherIcon = weatherIcon;
		this.img = img;
		this.newimg = newimg;
		this.imageLabel = imageLabel;
		this.cityName = cityName;
		this.temp = temp;
		this.shortDescription = shortDescription;
		this.tempMin = tempMin;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
	}

	@Override
	public void run() {
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

	public void DisplayInfo(String zip) throws IOException {
		// this.container = this.getContentPane();
		this.container.setLayout(null);
		StringBuilder zipBuilder = new StringBuilder();
		zipBuilder.append("http://api.openweathermap.org/data/2.5/weather?zip=");
		zipBuilder.append(zip);
		zipBuilder.append(",us&appid=2de143494c0b295cca9337e1e96b00e0&units=imperial");
		URL url = new URL(zipBuilder.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		// this will return for us a list of ufo sightings
		WeatherReport info = gson.fromJson(reader, WeatherReport.class);
		if (info.getMain() == null) {
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
			this.newimg = img.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
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
		// repaint();
	}
}
