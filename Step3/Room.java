package Step3;

public class Room implements Travelling {
	public boolean enterable;
	public Rooms north, south, east, west, roomName;

	public Room(Rooms roomName, boolean enterable, Rooms north, Rooms south, Rooms east, Rooms west) {
		this.roomName = roomName;
		this.enterable = enterable;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
	}

	public boolean getIsEnterable() {
		return enterable;
	}

	public void setIsEnterable(boolean enterable) {
		this.enterable = enterable;
	}

	public Rooms goNorth() {
		return north;

	}

	public Rooms goSouth() {
		return south;

	}

	public Rooms goEast() {
		return east;

	}

	public Rooms goWest() {

		return west;
	}
}
