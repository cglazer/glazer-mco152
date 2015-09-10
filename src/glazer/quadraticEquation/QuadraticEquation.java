package glazer.quadraticEquation;

public class QuadraticEquation {
	private double positiveX;
	private double negativeX;

	public QuadraticEquation(double a, double b, double c)
			throws InvalidDataException {
		if (a == 0 || b == 0) {
			throw new InvalidDataException();
		}
		this.positiveX = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
		this.negativeX = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
	}

	public double getPositiveX() {
		return this.positiveX;
	}

	public double getNegativeX() {
		return this.negativeX;
	}
}
