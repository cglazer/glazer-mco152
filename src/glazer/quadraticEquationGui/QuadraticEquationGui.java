package glazer.quadraticEquationGui;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class QuadraticEquationGui extends JFrame {

	private JLabel aLabel;
	private JLabel bLabel;
	private JLabel cLabel;
	private JLabel xLabel;
	private JTextField aText;
	private JTextField bText;
	private JTextField cText;
	private JTextField xText;
	private JButton button;

	public QuadraticEquationGui() {
		setTitle("Quadratic Equation");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
	}

}
