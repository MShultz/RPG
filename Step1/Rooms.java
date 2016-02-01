
public enum Rooms {
	ENTRANCE_HALL("Entrance Hall", 0),
	RIGHT_HALLWAY("Right Hallway",4 ),
	ADULT_BEDROOM("Adult Bedroom", 5),
	ADULT_CLOSET("Adult Closet",7 ),
	SECRET_PASSAGE("Secret Passage", 8),
	CHILD_CLOSET("Children's Closet",9 ),
	MYSTERY_BEDROOM("Mystery Bedroom", 6),
	ATTIC("Attic", 10),
	REST_ROOM("Rest Room",11 ),
	DINING_ROOM("Dining Room",1 ),
	KITCHEN("Kitchen", 2),
	BACK_ROOM("Back Room",3 ),
	LEFT_HALLWAY("Left Hallway",12 ),
	LOUNGE("Lounge", 13),
	SERVANT_REST_ROOM("Servant's Rest Room",15 ),
	SERVANT_QUARTER("Servant's Quarters",14 ),
	NONE("There is no way for you to go in this direction.");
	
	public String roomName;
	public int roomIndex;
	private Rooms(String roomName){
		this.roomName = roomName;
	}
	private Rooms(String roomName, int roomIndex){
		this.roomName = roomName;
		this.roomIndex = roomIndex;
	}
	
	public String getRoomName(){
		return roomName;
	}
	public int getRoomIndex(){
		return roomIndex;
	}
}
