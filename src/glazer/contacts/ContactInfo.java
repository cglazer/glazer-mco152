package glazer.contacts;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ContactInfo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int num;
	private JLabel name;
	private JLabel email;
	private JLabel phone;
	private JLabel street;
	private JLabel cityZip;
	private Contacts[] contacts;
	private Object o;

	Container container;

	public ContactInfo(Object o, Contacts[] contacts) {
		setTitle("JFrameDemo");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.o = o;

		this.contacts = contacts;
		this.name = new JLabel();
		this.email = new JLabel();
		this.phone = new JLabel();
		this.street = new JLabel();
		this.cityZip = new JLabel();
		this.container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		add(this.name);
		add(this.email);
		add(this.phone);
		add(this.street);
		add(this.cityZip);

		for (int i = 0; i < contacts.length; i++) {
			if (o.toString().equalsIgnoreCase(contacts[i].getName())) {
				this.num = i;
				break;
			}
		}

		this.name.setText(this.contacts[this.num].getName());
		this.email.setText(this.contacts[this.num].getEmail());
		this.phone.setText(this.contacts[this.num].getPhone());
		this.street.setText(this.contacts[this.num].getAddress().getStreet());
		this.cityZip.setText(this.contacts[this.num].getAddress().getCity() + ", "
				+ contacts[num].getAddress().getZipcode());

	}

}
