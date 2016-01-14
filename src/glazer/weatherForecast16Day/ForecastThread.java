package glazer.weatherForecast16Day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;

import com.google.gson.Gson;

public class ForecastThread extends Thread {
	// private JButton[] panelWeek1;
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
	private SimpleDateFormat format;
	private Date dates;
	private JLabel nightTemp;
	private JLabel mornTemp;
	private JLabel[] tempLabel;
	private JLabel[] dateLabel;
	private JLabel[] iconLabel;
	private IconThread iThread;

	public ForecastThread(JLabel cityName, JLabel todayTemp,
			JLabel todayMinMax, JLabel todayHumidity, JLabel todayWind,
			JLabel todayIcon, JLabel description, JLabel date, String zip,
			JLabel nightTemp, JLabel mornTemp, int centerDay,
			JLabel[] tempLabel, JLabel[] dateLabel, JLabel[] iconLabel) {
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
		this.format = new SimpleDateFormat("EEE, MMM d");
		this.nightTemp = nightTemp;
		this.mornTemp = mornTemp;
		this.tempLabel = tempLabel;

		this.dateLabel = dateLabel;
		this.iconLabel = iconLabel;
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

			for (int i = 0; i < 16; i++) {
				Weather[] weather = this.day[i].getWeather();
				if (i < 8) {
					this.tempLabel[i].setText(String.valueOf((int) this.day[i]
							.getTemp().getDay()) + "\u2109");
					this.dates = new Date(this.day[i].getDt() * 1000);
					this.dateLabel[i].setText(this.format.format(this.dates));
					this.iThread = new IconThread(weather[0].getIcon(),
							this.iconLabel[i], 1);
					this.iThread.start();
				} else {
					this.tempLabel[i].setText(String.valueOf((int) day[i]
							.getTemp().getDay()) + "\u2109");
					this.dates = new Date(this.day[i].getDt() * 1000);
					this.dateLabel[i].setText(this.format.format(this.dates));
					this.iThread = new IconThread(weather[0].getIcon(),
							this.iconLabel[i], 1);
					this.iThread.start();
				}
			}

		}
	}

	public void setCenter() {
		this.cityName.setText(info.getCity().getName());
		Date todayDate = new Date(day[centerDay].getDt() * 1000);
		this.date.setText(this.format.format(todayDate));
		this.todayHumididy.setText("Humidity: "
				+ String.valueOf(this.day[this.centerDay].getHumidity()) + "%");
		this.nightTemp.setText("Night Temp: "
				+ String.valueOf(this.day[this.centerDay].getTemp().getNight())
				+ "\u2109");
		this.mornTemp.setText("Morning Temp: "
				+ String.valueOf(this.day[this.centerDay].getTemp().getMorn())
				+ "\u2109");

		this.todayWind.setText("Wind Speed: "
				+ String.valueOf(this.day[this.centerDay].getSpeed()) + " MPH");
		Weather[] todayWeather = this.day[this.centerDay].getWeather();
		IconThread iconThread = new IconThread(todayWeather[0].getIcon(),
				this.todayIcon, 0);
		iconThread.start();
		this.description.setText(todayWeather[0].getMain());
		this.todayTemp.setText(String.valueOf((int) this.day[this.centerDay]
				.getTemp().getDay()) + "\u2109");
		this.todayMinMax.setText("L: "
				+ String.valueOf(this.day[this.centerDay].getTemp().getMin()
						+ "   / H: "
						+ String.valueOf(this.day[this.centerDay].getTemp()
								.getMax())));
	}
}