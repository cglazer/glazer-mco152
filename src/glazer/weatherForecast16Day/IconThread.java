package glazer.weatherForecast16Day;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class IconThread extends Thread {

	private String iconCode;
	private JLabel icon;
	private JButton button;

	public IconThread(String iconCode, JLabel icon) {
		this.iconCode = iconCode;
		this.icon = icon;
	}

	public IconThread(String iconCode, JButton button) {
		// TODO Auto-generated constructor stub
		this.iconCode = iconCode;
		this.button = button;
	}

	@Override
	public void run() {
		URL imgURL = null;
		try {
			imgURL = new URL("http://openweathermap.org/img/w/" + this.iconCode
					+ ".png");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageIcon weatherIcon = new ImageIcon(imgURL);
		// Image img = weatherIcon.getImage();
		// Image newimg = img.getScaledInstance(75, 75,
		// java.awt.Image.SCALE_SMOOTH);
		// weatherIcon = new ImageIcon(newimg);
		if (button == null) {
			this.icon.setIcon(weatherIcon);
		} else {
			this.button.setIcon(weatherIcon);
		}
	}
}
