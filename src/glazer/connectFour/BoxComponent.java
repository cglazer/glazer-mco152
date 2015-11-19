package glazer.connectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class BoxComponent extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String color;
	Boolean flagged;
	private Color boxColor;
	int y;

	public BoxComponent() {
		flagged = false;
		setBackground(Color.BLUE);
		y = 0;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		g.setColor(boxColor);
		g.fillOval((width - height) / 2, 0, height, height);
	}

	public void setRed() {
		if (!flagged) {
			boxColor = Color.RED;
			this.flagged = true;
			repaint();
		}
	}

	public void setYellow() {
		if (!flagged) {
			boxColor = Color.YELLOW;
			this.flagged = true;
			repaint();
		}
	}

	public Color getColor() {
		return this.boxColor;
	}

	public boolean isFlagged() {
		return this.flagged;
	}
}
