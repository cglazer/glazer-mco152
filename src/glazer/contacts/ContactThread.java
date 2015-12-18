package glazer.contacts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.google.gson.Gson;

public class ContactThread extends Thread {

	private Contacts[] contacts;
	private DefaultListModel<String> listModel;
	private JList<String> listBox;

	public ContactThread(DefaultListModel listData, JList listBox) {
		this.listModel = listData;
		this.contacts = null;
		this.listBox = listBox;

	}

	@Override
	public void run() {
		URL url = null;
		try {
			url = new URL("http://jsonplaceholder.typicode.com/users");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStream in = null;
		try {
			in = connection.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();

		contacts = gson.fromJson(reader, Contacts[].class);
		setList();
	}

	public void setList() {
		for (int i = 0; i < contacts.length; i++) {
			this.listModel.addElement(this.contacts[i].getName());
		}
		List<String> list = new ArrayList<>();
		for (int i = 0; i < listModel.size(); i++) {
			list.add(listModel.get(i));
		}
		Collections.sort(list);
		listModel.removeAllElements();
		for (String s : list) {
			listModel.addElement(s);
		}
		this.listBox.setModel(listModel);
		listBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				JList<?> list = (JList<?>) evt.getSource();
				if (evt.getClickCount() == 2) {
					// Double-click detected
					int index = list.locationToIndex(evt.getPoint());
					Object o = list.getModel().getElementAt(index);

					ContactInfo info = new ContactInfo(o, contacts);
					info.setVisible(true);

				}
			}
		});
	}

}
