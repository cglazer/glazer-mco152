package glazer.pythagoreanTheorem;

public class PythagoreanTheorem {
	private double a;
	private double b;
	private double c;

	public PythagoreanTheorem() {
		this.a = 0;
		this.b = 0;
		this.c = 0;
	}

	public void setAB(double a, double b) throws InvalidDataException {
		if (a <= 0 || b <= 0) {
			throw new InvalidDataException();
		}
		this.a = a;
		this.b = b;
		this.c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}

	public void setAC(double a, double c) throws InvalidDataException {
		if (a <= 0 || c <= a) {
			throw new InvalidDataException();
		}
		this.a = a;
		this.c = c;
		this.b = Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
	}

	public void setBC(double b, double c) throws InvalidDataException {
		if (b <= 0 || c <= b) {
			throw new InvalidDataException();
		}
		this.b = b;
		this.c = c;
		this.a = Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2));
	}

	public double getA() throws InvalidDataException {
		if (this.b == 0 || this.c == 0) {
			throw new InvalidDataException();
		}
		return this.a;
	}

	public double getB() throws InvalidDataException {
		if (this.a == 0 || this.c == 0) {
			throw new InvalidDataException();
		}
		return this.b;
	}

	public double getC() throws InvalidDataException {
		if (this.a == 0 || this.b == 0) {
			throw new InvalidDataException();
		}
		return this.c;
	}
}
