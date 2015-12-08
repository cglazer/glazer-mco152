package glazer.calculatePi;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PiFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public PiFrame() {
		setTitle("");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("Pi Calculation in progress");
		Container contentPane = getContentPane();
		contentPane.add(label);

		PiCalculationThread thread = new PiCalculationThread(label);

		thread.start();
	}

	public static void main(String args[]) {
		new PiFrame().setVisible(true);
	}

}
