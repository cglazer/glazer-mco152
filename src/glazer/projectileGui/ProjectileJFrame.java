package glazer.projectileGui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class ProjectileJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProjectileJFrame() {
		setTitle("Projectile");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		container.add(BorderLayout.CENTER, new ProjectileComponent());
	}

	public static void main(String args[]) {
		ProjectileJFrame frame = new ProjectileJFrame();
		frame.setVisible(true);
	}
}
