package glazer.weatherForecast16Day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.google.gson.Gson;

public class ForecastThread extends Thread {
	private JButton[] panelWeek1;
	private JButton[] panelWeek2;
	private JLabel cityName;
	private JLabel todayTemp;
	private JLabel todayMinMax;
	private JLabel todayHumididy;
	private JLabel todayWind;
	private JLabel todayIcon;
	private JLabel description;
	private JLabel date;
	private String zip;
	private WeatherReport info;
	private List[] day;
	private int centerDay;

	public ForecastThread(JButton[] panelWeek1, JButton[] panelWeek2,
			JLabel cityName, JLabel todayTemp, JLabel todayMinMax,
			JLabel todayHumidity, JLabel todayWind, JLabel todayIcon,
			JLabel description, JLabel date, String zip, int centerDay) {
		this.panelWeek1 = panelWeek1;
		this.panelWeek2 = panelWeek2;
		this.cityName = cityName;
		this.todayTemp = todayTemp;
		this.todayMinMax = todayMinMax;
		this.todayHumididy = todayHumidity;
		this.todayWind = todayWind;
		this.todayIcon = todayIcon;
		this.description = description;
		this.date = date;
		this.centerDay = centerDay;
		this.zip = zip;

	}

	@Override
	public void run() {

		String forecastURL = "http://api.openweathermap.org/data/2.5/forecast/daily?q="
				+ this.zip
				+ "&units=imperial&cnt=16&appid=2de143494c0b295cca9337e1e96b00e0";

		InputStream in = null;
		try {
			URL url = new URL(forecastURL);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			in = connection.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		this.info = gson.fromJson(reader, WeatherReport.class);
		this.day = info.getList();
		if (info.getCity() == null) {
			System.out.println("Invalid Zip Code");
		} else {
			setCenter();

			for (int i = 0; i < 8; i++) {
				panelWeek1[i].setText(String.valueOf((int) day[i].getTemp()
						.getDay()) + "\u2109");
				panelWeek2[i].setText(String.valueOf((int) day[i + 8].getTemp()
						.getDay()) + "\u2109");
			}
			IconThread iThread;
			for (int i = 0; i < 16; i++) {
				Weather[] weather = day[i].getWeather();
				if (i < 8) {
					iThread = new IconThread(weather[0].getIcon(),
							panelWeek1[i]);
					iThread.start();
				} else {
					iThread = new IconThread(weather[0].getIcon(),
							panelWeek2[i - 8]);
					iThread.start();
				}
			}

		}
	}

	public void setCenter() {
		this.cityName.setText(info.getCity().getName());

		Date todayDate = new Date(day[centerDay].getDt() * 1000);
		SimpleDateFormat format = new SimpleDateFormat("EEE, MMM d");
		this.date.setText(format.format(todayDate));
		this.todayHumididy.setText("Humidity: "
				+ String.valueOf(day[centerDay].getHumidity()) + "%");
		this.todayWind.setText("Wind Speed: "
				+ String.valueOf(day[this.centerDay].getSpeed()));
		Weather[] todayWeather = day[this.centerDay].getWeather();
		IconThread iconThread = new IconThread(todayWeather[0].getIcon(),
				this.todayIcon);
		iconThread.start();
		this.description.setText(todayWeather[0].getMain());
		System.out.println(todayWeather[0].getIcon());

		this.todayTemp.setText(String.valueOf((int) day[this.centerDay]
				.getTemp().getDay()) + "\u2109");
		this.todayMinMax
				.setText("L: "
						+ String.valueOf(day[this.centerDay].getTemp().getMin()
								+ "   / H: "
								+ String.valueOf(day[this.centerDay].getTemp()
										.getMax())));
	}
}