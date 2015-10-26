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
		for (int i = 1; i <= 20; i++) {
			double x = p.getX();
			double y = p.getY();
			p.setTime(i);
			g2d.draw(new Line2D.Double(x, (getHeight() - y), p.getX(),
					(getHeight() - p.getY())));
		}
	}
}
