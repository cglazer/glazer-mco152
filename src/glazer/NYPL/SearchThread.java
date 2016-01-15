package glazer.NYPL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;

import com.google.gson.Gson;

public class SearchThread extends Thread {
	private SearchList searchList;
	private ListModel<String> listModel;
	private JList<String> listBox;
	private Result[] result;
	private String searchTopic;

	private NYPLFrame me;

	public SearchThread(DefaultListModel<String> listModel, JList<String> listBox, JLabel icon, String searchTopic,
			JLabel numOfNum, JButton previous, JButton next, NYPLFrame me) {
		this.listModel = listModel;
		this.listBox = listBox;
		this.searchTopic = searchTopic;
		this.me = me;

	}

	@Override
	public void run() {
		URL url = null;
		try {
			url = new URL("http://api.repo.nypl.org/api/v1/items/search?q=" + searchTopic + "&publicDomainOnly=true");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpURLConnection connection;
		try {
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", "Token token=\"h8ursz9f4t1lekeh\"");
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			Gson gson = new Gson();
			searchList = gson.fromJson(reader, SearchList.class);
			setList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setList() {
		NyplAPI api = searchList.getNyplAPI();
		Response response = api.getResponse();
		// int numResults = response.getNumResults();
		result = response.getResult();
		((DefaultListModel<String>) this.listModel).removeAllElements();
		for (int i = 0; i < result.length; i++) {
			String title = result[i].getTitle();
			if (title.length() > 30) {
				title = title.substring(0, 30) + "...";
			}
			((DefaultListModel<String>) this.listModel).addElement(title);
		}

		this.listBox.setModel(listModel);
		me.setResult(result);

	}

}
