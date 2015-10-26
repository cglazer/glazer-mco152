package glazer.projectileGui;

import glazer.physics.Projectile;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class ProjectileComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Projectile p = new Projectile(31, 20, 0);
		double nextX = p.getX();
		double nextY = getHeight() - p.getY();
		for (int i = 1; i <= 20; i++) {
			double x = nextX;
			double y = nextY;
			p.setTime(i);
			nextX = p.getX();
			nextY = getHeight() - p.getY();
			g2d.draw(new Line2D.Double(x, y, nextX, nextY));
		}
	}
}
