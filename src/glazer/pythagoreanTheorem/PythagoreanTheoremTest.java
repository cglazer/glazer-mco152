package glazer.pythagoreanTheorem;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTheoremTest {

	@Test
	public void testSetAB() throws InvalidDataException {
		PythagoreanTheorem p = new PythagoreanTheorem();
		p.setAB(3, 4);
		Assert.assertEquals(5, p.getC(), .01);
	}

	@Test
	public void testSetAC() throws InvalidDataException {
		PythagoreanTheorem p = new PythagoreanTheorem();
		p.setAC(3, 5);
		Assert.assertEquals(4, p.getB(), .01);
	}

	@Test
	public void testSetBC() throws InvalidDataException {
		PythagoreanTheorem p = new PythagoreanTheorem();
		p.setBC(4, 5);
		Assert.assertEquals(3, p.getA(), .01);
	}

	@Test
	public void testABInvalidDataException() {
		try {
			PythagoreanTheorem t = new PythagoreanTheorem();
			t.setAB(0, 0);
			Assert.fail("didn't throw exception");
		} catch (InvalidDataException e) {

		}
	}

	@Test
	public void testBCInvalidDataException() {
		try {
			PythagoreanTheorem t = new PythagoreanTheorem();
			t.setBC(0, 0);
			Assert.fail("didn't throw exception");
		} catch (InvalidDataException e) {

		}
	}

	@Test
	public void testACInvalidDataException() {
		try {
			PythagoreanTheorem t = new PythagoreanTheorem();
			t.setAC(0, 0);
			Assert.fail("didn't throw exception");
		} catch (InvalidDataException e) {

		}
	}
}
