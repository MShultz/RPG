
public class Adventurer extends Statistics implements CharacterCreation {
	String adventurerName;
	int adventurerHealth, currentHealth, stamina, attackPoints;
	Rooms currentRoom, previousRoom;
	Room adventurerRoom;

	public Adventurer(String adventurerName, int strength, int dexterity, int intellegence, int luck) {
		super(strength, dexterity, intellegence, luck);
		this.adventurerName = adventurerName;
		adventurerHealth = 180;
		stamina = 10;
		currentRoom = Rooms.ENTRANCE_HALL;
	}

	public void setCurrentHealth(int healthNum, boolean isDamage) {
		if (adventurerHealth >= 180) {
			System.out.println("Your adventurer has maximum health");
		} else {
			adventurerHealth = (isDamage ? adventurerHealth - healthNum : adventurerHealth + healthNum);
		}
	}
	public void setPreviousRoom(){
		previousRoom = currentRoom;
	}
	public void setCurrentRoom(Rooms room){
		
		currentRoom = room;
		
	}

	public int getCurrentHealth() {
		return adventurerHealth;
	}

	public void normalAttack() {

	}

	public void strongAttack() {
		if (stamina == 0) {
			System.out.println(
					"You're out of breath; your muscles are aching. You can't put your all into an attack right now.");
		}
	}

	public int getStamina() {
		return stamina;
	}

	public String getAdventurerName() {
		return adventurerName;
	}
	public Rooms getCurrentRoomName(){
		return currentRoom;
	}
	public Rooms getPreviousRoomName(){
		return previousRoom;
	}

	@Override
	public String toString() {
		return this.getAdventurerName() + "\nHealth: " + this.getCurrentHealth() + "\nStamina: " + getStamina()
				+ "\nStrength: " + this.getStrength() + "\nDexterity: " + this.getDexterity() + "\nIntellegence: "
				+ this.getIntellegence() + "\nLuck: " + this.getLuck();
	}
}
