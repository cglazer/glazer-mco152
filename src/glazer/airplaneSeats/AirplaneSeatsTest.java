package glazer.airplaneSeats;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class AirplaneSeatsTest {

	@Test
	/**
	 * Test the output of toString() on an empty plane. Do not modify this method.
	 */
	// done
	public void testToStringWithEmptyPlane() {
		AirplaneSeats seats = new AirplaneSeats(3, 4);
		Assert.assertEquals("  ABCD\n" + "1 oooo\n" + "2 oooo\n" + "3 oooo\n",
				seats.toString());
	}

	@Test
	/**
	 * Test the output of toString() on an full plane. Do not modify this method.
	 */
	// done
	public void testToStringWithFullPlane() throws AlreadyReservedException,
			SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(3, 4);
		seats.reserveAll("A1", "B1", "C1", "D1");
		seats.reserveAll("A2", "B2", "C2", "D2");
		seats.reserveAll("A3", "B3", "C3", "D3");
		Assert.assertEquals("  ABCD\n" + "1 ####\n" + "2 ####\n" + "3 ####\n",
				seats.toString());
	}

	@Test
	/**
	 * Tests that reserve() reserves a seat correctly.
	 */
	public void testReserve() throws AlreadyReservedException,
			SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(3, 4);
		seats.reserve("A1");
		Assert.assertTrue(seats.isReserved("A1"));
	}

	@Test
	/**
	 * Tests that reserve() will throw an AlreadyReservedException if you attempt to reserve
	 * a seat twice. Do not modify this method.
	 */
	// done
	public void testReserveThrowsAlreadyReservedException()
			throws SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(2, 2);
		try {
			seats.reserve("A1");
			seats.reserve("A1");
			Assert.fail("exception didn't work");
		} catch (AlreadyReservedException e) {
			// This is expected so catch it so the test passes
		}
	}

	@Test
	/**
	 * Tests that reserve() will thrown a SeatOutOfBoundsException is you attempt to reserve
	 * a seat that is outside the bounds of the plane. 
	 */
	public void testReserveThrowsSeatOutOfBoundsException()
			throws AlreadyReservedException {
		AirplaneSeats seats = new AirplaneSeats(2, 2);
		try {
			seats.reserve("B3");
			Assert.fail("Test did not work");
		} catch (SeatOutOfBoundsException e) {

		}
	}

	@Test
	/**
	 * Tests that isFullPlane() returns false if there are empty seats on the plane. 
	 */
	public void testIsPlaneFullReturnsFalse() {
		AirplaneSeats seats = new AirplaneSeats(30, 5);
		Assert.assertFalse(seats.isPlaneFull());
	}

	@Test
	/**
	 * Tests that isFullPlane() returns true if there are no empty seats on the plane. 
	 */
	public void testIsPlaneFullReturnsTrue() {
		AirplaneSeats seats = new AirplaneSeats(0, 0);
		Assert.assertTrue(seats.isPlaneFull());
	}

	@Test
	/**
	 * Tests that reserveGroup() reserves the correct seats when called on an empty plane.
	 */
	public void testReserveGroupOnEmptyPlane() throws NotEnoughSeatsException {
		AirplaneSeats seats = new AirplaneSeats(10, 5);
		ArrayList<String> array = new ArrayList<String>();
		array.add("A1");
		array.add("B1");
		array.add("C1");
		Assert.assertEquals(array, seats.reserveGroup(3));
	}

	@Test
	/**
	 * Tests that reserveGroup() reserves the correct seats when called on a plane that has
	 * seats already reserved. For instance, on a 3,4 airplane whose "A1" is occupied, 
	 * calling reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 */
	public void testReserveGroupOnPartiallyFilledPlane()
			throws NotEnoughSeatsException, AlreadyReservedException,
			SeatOutOfBoundsException {
		AirplaneSeats seats = new AirplaneSeats(3, 4);
		seats.reserve("A1");
		ArrayList<String> array = new ArrayList<String>();
		array.add("A2");
		array.add("B2");
		array.add("C2");
		Assert.assertEquals(array, seats.reserveGroup(3));
	}

	@Test
	/**
	 * Tests that reserveGroup() throws NotEnoughSeatsException if there are not enough 
	 * seats available together for the group.
	 */
	public void testReserveGroupThrowsNotEnoughSeatsException() {
		AirplaneSeats seats = new AirplaneSeats(0, 0);
		try {
			seats.reserveGroup(3);
			Assert.fail("Test didn't work");
		} catch (NotEnoughSeatsException e) {

		}

	}

}
