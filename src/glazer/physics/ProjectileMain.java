package glazer.physics;

public class ProjectileMain {
	public static void main(String args[]) {

		double angle = 31;
		double velocity = 20;
		double time = 0;

		Projectile location = new Projectile(angle, velocity, time);

		for (time = 0; time < 11; time++) {
			location.setTime(time);
			System.out.println(time + " seconds x= " + location.getX());
			System.out.println(time + " seconds y= " + location.getY());
		}

	}
}
