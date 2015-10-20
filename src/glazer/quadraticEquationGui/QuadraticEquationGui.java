package glazer.quadraticEquationGui;

import glazer.quadraticEquation.InvalidDataException;
import glazer.quadraticEquation.QuadraticEquation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class QuadraticEquationGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel aLabel;
	private JLabel bLabel;
	private JLabel cLabel;
	private JLabel xLabel;
	private JLabel answerLabel;
	private JLabel answerLabel2;
	private JTextField aText;
	private JTextField bText;
	private JTextField cText;
	private JButton button;

	public QuadraticEquationGui() {
		setTitle("Quadratic Equation");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		this.aLabel = new JLabel("A");
		this.bLabel = new JLabel("B");
		this.cLabel = new JLabel("C");
		this.xLabel = new JLabel(
				"X= (If the result is an imaginary number, it will display as 'NaN')");
		this.answerLabel = new JLabel();
		this.answerLabel2 = new JLabel();
		this.aText = new JTextField();
		this.bText = new JTextField();
		this.cText = new JTextField();
		this.button = new JButton("Compute");

		add(aLabel);
		add(aText);
		add(bLabel);
		add(bText);
		add(cLabel);
		add(cText);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				QuadraticEquation q = null;
				try {
					q = new QuadraticEquation(Double.parseDouble(aText
							.getText()), Double.parseDouble(bText.getText()),
							Double.parseDouble(cText.getText()));
					answerLabel.setText(String.valueOf(q.getNegativeX()));
					answerLabel2.setText(String.valueOf(q.getPositiveX()));
					answerLabel.setText(String.valueOf(q.getNegativeX()));
					answerLabel2.setText(String.valueOf(q.getPositiveX()));
				} catch (NumberFormatException e) {
					System.out
							.println("Numeric data must be entered in all text fields");
				} catch (InvalidDataException e) {
					System.out
							.println("Invalid data. The values of A and B cannot be equal to zero.");
				}

				// TODO Auto-generated method stub

			}
		});
		add(button);
		add(xLabel);
		add(answerLabel);
		add(answerLabel2);

	}

}
