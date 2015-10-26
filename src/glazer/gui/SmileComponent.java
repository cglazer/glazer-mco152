package glazer.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.yellow);
		g.fillOval(200, 130, 400, 400);
		g.setColor(Color.BLUE);
		g.fillOval(300, 180, 50, 50);
		g.setColor(Color.BLACK);
		g.fillOval(320, 200, 15, 15);
		g.setColor(Color.BLUE);
		g.fillOval(450, 180, 50, 50);
		g.setColor(Color.BLACK);
		g.fillOval(470, 200, 15, 15);
		g.setColor(Color.red);
		g.fillArc(300, 240, 215, 250, 0, -180);
		g.setColor(Color.gray);
		g.fillRect(250, 115, 300, 50);
		g.fillRect(335, 35, 130, 130);
		g.setColor(Color.darkGray);
		g.drawArc(375, 275, 40, 40, 0, 190);

	}

}
