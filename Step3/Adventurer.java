package Step3;

import java.util.Random;

public class Adventurer extends Being {
	Random rand = new Random();
	private final static int BOUND = 1001;
	private final static int MAX_STAMINA = 10;
	private final static int MAX_HEALTH = 75;
	String adventurerName;
	int adventurerHealth, stamina, attackPoints;
	Rooms currentRoom, previousRoom;
	Room adventurerRoom;
	LootBag inventory;

	public Adventurer(String adventurerName, int strength, int dexterity, int intellegence, int luck) {
		super(strength, dexterity, intellegence, luck, MAX_HEALTH, MAX_STAMINA, adventurerName);
		currentRoom = Rooms.ENTRANCE_HALL;
		inventory = new LootBag();
	}

	public void takeLoot() {
		if (rand.nextBoolean()) {
			LootBag spoils = new LootBag(rand.nextInt(BOUND));
			spoils.printContents(false);
			inventory.addToInventory(spoils.getLootMap());
			inventory.printContents(true);
		}
		else{
			System.out.println("You search the dead being's body, but find nothing of value.");
		}
	}

	public void checkInventory() {
		inventory.printContents(true);
	}

	public void reset() {
		resetStamina(MAX_STAMINA);
		setCurrentHealth(MAX_HEALTH);
	}

	public void setPreviousRoom() {
		previousRoom = currentRoom;
	}

	public void setCurrentRoom(Rooms room) {
		currentRoom = room;
	}

	public Rooms getCurrentRoomName() {
		return currentRoom;
	}

	public Rooms getPreviousRoomName() {
		return previousRoom;
	}

	@Override
	public String toString() {
		return this.getBeingName() + "\nHealth: " + this.getCurrentHealth() + "\nStamina: " + getStamina()
				+ "\nStrength: " + this.getStrength() + "\nDexterity: " + this.getDexterity() + "\nIntellegence: "
				+ this.getIntellegence() + "\nLuck: " + this.getLuck();
	}

}
