package glazer.physics;

public class Projectile {
	private double angle;
	private double velocity;
	private double time;
	private double radians;

	public Projectile(double angle, double velocity, double time) {
		this.angle = angle;
		this.velocity = velocity;
		this.time = time;
		radians = Math.toRadians(this.angle);
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getX() {
		return Math.sin(radians) * this.velocity * this.time;

	}

	public double getY() {
		return Math.cos(radians) * this.velocity * this.time - (.5 * 9.8 * this.time * this.time);

	}
}
