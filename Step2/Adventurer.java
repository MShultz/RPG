package Step2;

public class Adventurer extends Being {
	private final static int MAX_STAMINA = 10; 
	private final static int MAX_HEALTH = 180;
	String adventurerName;
	int adventurerHealth, stamina, attackPoints;
	Rooms currentRoom, previousRoom;
	Room adventurerRoom;

	public Adventurer(String adventurerName, int strength, int dexterity, int intellegence, int luck) {
		super(strength, dexterity, intellegence, luck);
		this.adventurerName = adventurerName;
		adventurerHealth = MAX_HEALTH;
		stamina = MAX_STAMINA;
		currentRoom = Rooms.ENTRANCE_HALL;
	}
	public void setCurrentHealth(int healthNum, boolean isDamage){
		adventurerHealth = this.getNewHealth(adventurerHealth, healthNum, isDamage); 
	}

	public void setCurrentStamina(){
		stamina = this.getCurrentStamina(stamina);
	}
	public void reset(){
		stamina = MAX_STAMINA;
		adventurerHealth = MAX_HEALTH;
	}

	public void setPreviousRoom() {
		previousRoom = currentRoom;
	}

	public void setCurrentRoom(Rooms room) {
		currentRoom = room;
	}

	public int getCurrentHealth() {
		return adventurerHealth;
	}

	public int getStamina() {
		return stamina;
	}

	public String getAdventurerName() {
		return adventurerName;
	}

	public Rooms getCurrentRoomName() {
		return currentRoom;
	}

	public Rooms getPreviousRoomName() {
		return previousRoom;
	}

	@Override
	public String toString() {
		return this.getAdventurerName() + "\nHealth: " + this.getCurrentHealth() + "\nStamina: " + getStamina()
				+ "\nStrength: " + this.getStrength() + "\nDexterity: " + this.getDexterity() + "\nIntellegence: "
				+ this.getIntellegence() + "\nLuck: " + this.getLuck();
	}

}
