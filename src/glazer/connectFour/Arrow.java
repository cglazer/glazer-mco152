package glazer.connectFour;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JComponent;

public class Arrow extends JComponent {
	private static final long serialVersionUID = 1L;
	private int y = 0;
	Polygon p;
	Color triangleColor;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (y % 6 == 0) {
			g.setColor(getBackground());
		} else {
			g.setColor(Color.red);
		}
		p = new Polygon();
		p.addPoint(19, 10);
		p.addPoint(55, 40);
		p.addPoint(91, 10);
		g2.setColor(triangleColor);
		g2.fill(p);
		y++;
		super.repaint();
	}

	public void setColor(Color color) {
		triangleColor = color;
		repaint();
	}
}
