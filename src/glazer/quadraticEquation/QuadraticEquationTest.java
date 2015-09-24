package glazer.quadraticEquation;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testGetPositiveX() throws InvalidDataException {
		QuadraticEquation q = new QuadraticEquation(1, 3, -4);

		Assert.assertEquals(1, q.getPositiveX(), .01);
	}

	@Test
	public void testGetNegativeX() throws InvalidDataException {
		QuadraticEquation q = new QuadraticEquation(1, 3, -4);

		Assert.assertEquals(-4, q.getNegativeX(), .01);
	}

	@Test
	public void testThrowsInvalidDataException() {
		try {
			new QuadraticEquation(0, 0, 0);
			Assert.fail("didn't throw exception");
		} catch (InvalidDataException e) {

		}
	}
}
