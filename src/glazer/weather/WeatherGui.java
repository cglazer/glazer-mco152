package glazer.weather;

import java.net.MalformedURLException;

public class WeatherGui {
	public static void main(String[] args) {

		WeatherFrame frame = null;
		try {
			frame = new WeatherFrame();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setVisible(true);

	}
}
