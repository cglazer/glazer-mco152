package glazer.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {
	private int y = 0;
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
		g.fillOval(320 - y / 3, 200 - y / 3, y, y);
		g.setColor(Color.BLUE);
		g.fillOval(450, 180, 50, 50);
		g.setColor(Color.BLACK);
		g.fillOval(470 - y / 3, 200 - y / 3, y, y);
		g.setColor(Color.red);
		g.fillArc(300, 240, 215, 250, 0, -180);
		g.setColor(Color.gray);
		g.fillRect(250, 115, 300, 50);
		g.fillRect(335, 35, 130, 130);
		g.setColor(Color.darkGray);
		g.drawArc(375, 275, 40, 40, 0, 180);
		y++;
		if (y == 35) {
			y = 0;
		}
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.repaint();
	}

}
