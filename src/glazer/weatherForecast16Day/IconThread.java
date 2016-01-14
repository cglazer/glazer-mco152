package glazer.weatherForecast16Day;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class IconThread extends Thread {

	private String iconCode;
	private JLabel icon;
	private int num;
	private ImageIcon weatherIcon;

	public IconThread(String iconCode, JLabel icon, int num) {
		this.iconCode = iconCode;
		this.icon = icon;
		this.num = num;
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
		this.weatherIcon = new ImageIcon(imgURL);

		if (this.num == 0) {
			Image img = weatherIcon.getImage();
			Image newimg = img.getScaledInstance(125, 125,
					java.awt.Image.SCALE_SMOOTH);
			this.weatherIcon = new ImageIcon(newimg);
		}
		this.icon.setIcon(this.weatherIcon);

	}
}
