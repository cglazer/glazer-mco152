package glazer.physics;

public class Projectile {
	private double angle;
	private double velocity;
	private double time;

	public Projectile(double angle, double velocity, double time) {
		this.angle = angle;
		this.velocity = velocity;
		this.time = time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getX() {
		double radians = Math.toRadians(angle);
		return Math.sin(radians) * this.velocity * this.time;
	}

	public double getY() {
		double radians = Math.toRadians(angle);
		return Math.cos(radians) * this.velocity * this.time
				- (.5 * 9.8 * this.time * this.time);
	}

}
