package glazer.quadraticEquation;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {

	@Test
	public void testGetPositiveX() throws InvalidDataException {
		QuadraticEquation q = new QuadraticEquation(1, 3, -4);

		Assert.assertEquals(q.getPositiveX(), 1, .01);
	}

	@Test
	public void testGetNegativeX() throws InvalidDataException {
		QuadraticEquation q = new QuadraticEquation(1, 3, -4);

		Assert.assertEquals(q.getNegativeX(), -4, .01);
	}
}
