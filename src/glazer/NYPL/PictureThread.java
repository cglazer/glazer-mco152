package glazer.NYPL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.google.gson.Gson;

public class PictureThread extends Thread {
	private URL picURL;
	private SearchList images;
	private JLabel icon;
	private JLabel numOfNum;
	private JButton previous;
	private JButton next;
	private int currentImageIndex;
	private int numResults;
	private Capture[] capture;
	private PictureThread myself;
	private NYPLFrame me;

	public PictureThread(URL url, JLabel icon, JLabel numOfNum, JButton previous, JButton next, NYPLFrame me) {
		this.picURL = url;
		this.icon = icon;
		this.numOfNum = numOfNum;
		this.previous = previous;
		this.next = next;
		this.currentImageIndex = 0;
		this.myself = this;
		this.me = me;

	}

	@Override
	public void run() {

		HttpURLConnection connection;
		try {
			connection = (HttpURLConnection) this.picURL.openConnection();
			connection.setRequestProperty("Authorization", "Token token=\"h8ursz9f4t1lekeh\"");
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			Gson gson = new Gson();
			images = gson.fromJson(reader, SearchList.class);
			setImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setImage() {
		Response api = images.getNyplAPI().getResponse();
		this.numResults = api.getNumResults();
		capture = api.getCapture();
		if (numResults > 0) {
			resetImage();
		}
		this.me.setPicThread(myself);
	}

	public void previousImage() {
		// TODO Auto-generated method stub
		if (this.currentImageIndex > 0) {
			currentImageIndex--;
			resetImage();
		}
	}

	public void nextImage() {
		if (this.currentImageIndex < this.numResults - 1) {
			this.currentImageIndex++;
			resetImage();
		}
	}

	private void resetImage() {
		this.previous.setEnabled(true);
		this.next.setEnabled(true);
		this.numOfNum.setText(this.currentImageIndex + 1 + "/" + numResults);
		URL[] imageURL = capture[this.currentImageIndex].getImageLinks().getImageLink();
		DisplayPicThread thread = new DisplayPicThread(imageURL[3], icon);
		thread.start();
		if (this.currentImageIndex == 0) {
			this.previous.setEnabled(false);
		} else if (this.currentImageIndex == this.numResults - 1) {
			this.next.setEnabled(false);
		}
	}

}
