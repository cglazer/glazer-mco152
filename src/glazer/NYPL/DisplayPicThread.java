package glazer.NYPL;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DisplayPicThread extends Thread {
	private URL url;
	private JLabel icon;

	public DisplayPicThread(URL url, JLabel icon) {
		this.url = url;
		this.icon = icon;
	}

	@Override
	public void run() {
		ImageIcon temp = new ImageIcon(url);
		this.icon.setIcon(temp);

	}

}
