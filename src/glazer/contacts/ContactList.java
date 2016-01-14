package glazer.contacts;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ContactList extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JList<?> listBox;
	private Container container;
	private DefaultListModel<?> listModel;
	private JScrollPane listScroller;

	public ContactList() {
		setTitle("Contact List");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.container = getContentPane();
		this.listModel = new DefaultListModel();
		this.listBox = new JList(listModel);
		this.listBox.setLayoutOrientation(JList.VERTICAL_WRAP);
		this.listBox.setVisibleRowCount(-1);
		this.listScroller = new JScrollPane(listBox);
		this.container.add(listBox, BorderLayout.CENTER);
		ContactThread thread = new ContactThread(this.listModel, this.listBox);
		thread.start();
	}
}
