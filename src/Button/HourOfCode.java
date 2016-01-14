package Button;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class HourOfCode {
	public static void main(String[] args) {

		System.out.println("Hello 12-B! What is your name");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		while (name.length() < 6) {

			name = JOptionPane.showInputDialog("Reenter your name");

		}
		if (name.length() > 8) {
			JOptionPane.showMessageDialog(null, "Your name is long.");
		} else {
			JOptionPane.showMessageDialog(null, "Your name is short.");
		}

	}
}
