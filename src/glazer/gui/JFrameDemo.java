package glazer.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameDemo extends JFrame {

	// private JTextField textField;
	private JLabel label;
	private JLabel label2;
	private JButton button1;
	private JLabel label3;
	// private JTextField;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JFrameDemo() {
		setTitle("JFrameDemo");
		setSize(800, 600);
		// what happens when you hit the x button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		// setLayout(new FlowLayout());
		// textField = new JTextField();
		label = new JLabel("All this text gets shown all the time");

		add(label);
		label2 = new JLabel("label 2");
		add(label2);
		button1 = new JButton("button1");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("The button was clicked");
				// TODO Auto-generated method stub

			}
		});
		add(button1);
		label3 = new JLabel("label 3");
		add(label3);

		// textField.setSize(new Dimension(200, 300));
		// textField.setText("Here is some text");
		// add(textField);
	}
}
