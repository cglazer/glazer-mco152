package glazer.NYPL;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class NYPLFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container container;
	private JTextField editSearch;
	private JButton searchButton;
	private JPanel northPanel;
	private JPanel southNorthPanel;
	private JButton previous;
	private JButton next;
	private JLabel numOfNum;
	private JPanel centerPanel;
	private JList<String> listBox;
	private DefaultListModel<String> listModel;
	private JScrollPane listScroller;
	private JLabel icon;
	private NYPLFrame me;
	private Result[] result;
	private PictureThread picThread;

	public NYPLFrame() {
		// numresults--says how many results came
		// then array of results, title and apiITemURL
		// next url-capture array--all images that have to do with that image.
		// Then in there we have many images all the same just diff resolution-
		// we want the 3rd or 4th image
		setTitle("NYPL Search");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.container = getContentPane();
		this.editSearch = new JTextField();
		this.searchButton = new JButton("Search");
		this.northPanel = new JPanel();
		this.southNorthPanel = new JPanel();
		this.previous = new JButton("Previous");
		this.next = new JButton("Next");
		this.numOfNum = new JLabel("0/0");
		this.centerPanel = new JPanel();
		this.listModel = new DefaultListModel<String>();
		this.listBox = new JList<String>(listModel);
		this.icon = new JLabel();
		this.listScroller = new JScrollPane(icon);
		this.me = this;
		this.result = null;
		setComponents();
		addComponents();
	}

	public void setComponents() {
		container.setLayout(new BorderLayout());
		this.northPanel.setLayout(new BorderLayout());
		this.centerPanel.setLayout(new BorderLayout());
		this.listBox.setLayoutOrientation(JList.VERTICAL_WRAP);
		this.listBox.setVisibleRowCount(-1);
		this.previous.setEnabled(false);
		this.next.setEnabled(false);
	}

	private void addComponents() {
		this.northPanel.add(this.searchButton, BorderLayout.EAST);
		this.northPanel.add(this.editSearch, BorderLayout.CENTER);
		this.centerPanel.add(this.southNorthPanel, BorderLayout.NORTH);
		// this.centerPanel.add(this.icon, BorderLayout.CENTER);
		this.centerPanel.add(this.listScroller, BorderLayout.CENTER);
		this.southNorthPanel.add(this.previous);
		this.southNorthPanel.add(this.numOfNum);
		this.southNorthPanel.add(this.next);
		container.add(this.northPanel, BorderLayout.NORTH);
		container.add(this.listBox, BorderLayout.WEST);
		this.container.add(this.centerPanel, BorderLayout.CENTER);

		this.editSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startSearch(editSearch.getText());
			}
		});
		this.searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startSearch(editSearch.getText());
			}
		});

		listBox.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent evt) {
				JList<?> list = (JList<?>) evt.getSource();
				if (evt.getClickCount() == 1) {
					// Double-click detected

					int index = list.getSelectedIndex();
					// Object o = list.getModel().getElementAt(index);

					PictureThread picThread = new PictureThread(result[index].getApiItemURL(), icon, numOfNum,
							previous, next, me);
					picThread.start();

				}
			}
		});
		this.previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				picThread.previousImage();
			}

		});
		this.next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				picThread.nextImage();
			}
		});
	}

	public void setResult(Result[] result) {
		this.result = result;
	}

	public void setPicThread(PictureThread picThread) {
		this.picThread = picThread;
	}

	public void startSearch(String searchTopic) {
		SearchThread thread = new SearchThread(listModel, listBox, icon, searchTopic, this.numOfNum, this.previous,
				this.next, this.me);
		thread.start();
	}
}
