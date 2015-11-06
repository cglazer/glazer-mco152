package glazer.airplaneSeats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {
	// hashmap--seat and boolean
	private HashMap<String, Boolean> map;
	private int rows;
	private int columns;

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		this.map = new HashMap<String, Boolean>();
		this.rows = rows;
		this.columns = columns;
		// decide how big plane is
		for (int i = 1; i < rows; i++) {
			for (int x = 65; x <= 65 + this.columns; x++) {
				StringBuilder seat = new StringBuilder();

				seat.append(String.valueOf((char) x));
				seat.append(i);
				this.map.put(seat.toString(), false);
			}
		}
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */
	public void reserve(String seatName) throws AlreadyReservedException, SeatOutOfBoundsException {
		if (!(this.map.containsKey(seatName))) {
			throw new SeatOutOfBoundsException();
		}
		if (this.map.get(seatName)) {
			throw new AlreadyReservedException();
		} else {
			this.map.put(seatName, true);
		}

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		return this.map.get(seatName);
	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided her for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */
	public void reserveAll(String... seatNames) throws AlreadyReservedException, SeatOutOfBoundsException {
		// to reserve a bunch of seats//does not need to be modified
		for (String seatName : seatNames) {
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of.
	 * 
	 *         ABCD\n 1 #oo#\n 2 #ooo\n 3 ###o\n 4 ##oo\n 5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {
		// return a string in the above format letters...a map of the plane
		StringBuilder setup = new StringBuilder();
		setup.append("  ");
		for (int x = 65; x <= 65 + this.columns; x++) {
			setup.append(String.valueOf(x));
		}
		setup.append("\n1 ");
		int columnCounter = 0;
		int rowCounter = 1;

		for (Map.Entry<String, Boolean> seats : this.map.entrySet()) {
			if (columnCounter == columns) {
				rowCounter++;
				setup.append("\n");
				setup.append(rowCounter);
				setup.append(" ");
				columnCounter = 0;

			}
			if (map.get(seats)) {
				setup.append("#");
			} else {
				setup.append("o");
			}
			columnCounter++;

		}
		return setup.toString();
	}

	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 */
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether) throws NotEnoughSeatsException {
		ArrayList<String> reservedSeats = new ArrayList<String>();
		// want seats next to eachother
		// each string is a seatname
		int totalSeats = this.rows * this.columns;
		if (numberOfSeatsTogether > totalSeats) {
			throw new NotEnoughSeatsException();
		}
		int available = 0;
		for (Map.Entry<String, Boolean> seats : this.map.entrySet()) {
			if (!seats.getValue()) {
				if (available == 0) {
					if (seats.getKey().charAt(1) == 'A') {
						reservedSeats.add(seats.getKey());
						available++;
					}
				} else {
					reservedSeats.add(seats.getKey());
					available++;
				}
			} else {
				available = 0;
				reservedSeats.clear();
			}
			if (available == numberOfSeatsTogether) {
				for (String reserved : reservedSeats) {
					this.map.put(reserved, true);
				}
				return reservedSeats;
			}
		}
		throw new NotEnoughSeatsException();
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		for (Map.Entry<String, Boolean> seats : this.map.entrySet()) {
			if (!(seats.getValue())) {
				return false;
			}
		}
		return true;
	}

}
