package glazer.connectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class YellowChecker extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.yellow);
		g.fillOval(0, 0, getWidth(), getHeight());
	}
}
