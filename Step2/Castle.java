package Step2;

import java.util.Random;
import java.util.Scanner;

public class Castle {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	Vampire vamp;
	private static final int SPAWN_CHANCE = 30;
	private static final int RAND_BOUND = 101;
	private static final int DIFFICULTY_BOUND = 3;
	private static final int OPTION_BOUND = 2;
	Adventurer adventurer;
	public String adventurerName, userInput, attackType;
	private boolean isValid;
	private boolean hasNotAttacked = true;
	private boolean attackedStrongly = false;
	private boolean done = false;
	private boolean chosen = false;
	private int ability;
	private int maxValue = 15;
	private int battleCounter = 0;
	public int strength, dexterity = 0, intellegence = 0, luck = 0;
	public Room[] map = {
			new Room(Rooms.ENTRANCE_HALL, true, Rooms.DINING_ROOM, Rooms.NONE, Rooms.RIGHT_HALLWAY, Rooms.LEFT_HALLWAY),
			new Room(Rooms.DINING_ROOM, false, Rooms.KITCHEN, Rooms.ENTRANCE_HALL, Rooms.NONE, Rooms.LOUNGE),
			new Room(Rooms.KITCHEN, true, Rooms.BACK_ROOM, Rooms.DINING_ROOM, Rooms.NONE, Rooms.NONE),
			new Room(Rooms.BACK_ROOM, false, Rooms.NONE, Rooms.KITCHEN, Rooms.NONE, Rooms.NONE),
			new Room(Rooms.RIGHT_HALLWAY, true, Rooms.REST_ROOM, Rooms.ENTRANCE_HALL, Rooms.ADULT_BEDROOM,
					Rooms.MYSTERY_BEDROOM),
			new Room(Rooms.ADULT_BEDROOM, true, Rooms.ADULT_CLOSET, Rooms.RIGHT_HALLWAY, Rooms.NONE, Rooms.NONE),
			new Room(Rooms.MYSTERY_BEDROOM, false, Rooms.CHILD_CLOSET, Rooms.RIGHT_HALLWAY, Rooms.NONE, Rooms.NONE),
			new Room(Rooms.ADULT_CLOSET, true, Rooms.SECRET_PASSAGE, Rooms.ADULT_BEDROOM, Rooms.NONE, Rooms.NONE),
			new Room(Rooms.SECRET_PASSAGE, true, Rooms.CHILD_CLOSET, Rooms.ADULT_CLOSET, Rooms.NONE, Rooms.NONE),
			new Room(Rooms.CHILD_CLOSET, true, Rooms.SECRET_PASSAGE, Rooms.MYSTERY_BEDROOM, Rooms.NONE, Rooms.NONE),
			new Room(Rooms.ATTIC, false, Rooms.NONE, Rooms.RIGHT_HALLWAY, Rooms.NONE, Rooms.REST_ROOM),
			new Room(Rooms.REST_ROOM, true, Rooms.NONE, Rooms.RIGHT_HALLWAY, Rooms.ATTIC, Rooms.NONE),
			new Room(Rooms.LEFT_HALLWAY, true, Rooms.SERVANT_QUARTER, Rooms.ENTRANCE_HALL, Rooms.LOUNGE,
					Rooms.SERVANT_REST_ROOM),
			new Room(Rooms.LOUNGE, false, Rooms.NONE, Rooms.LEFT_HALLWAY, Rooms.DINING_ROOM, Rooms.NONE),
			new Room(Rooms.SERVANT_QUARTER, true, Rooms.NONE, Rooms.LEFT_HALLWAY, Rooms.NONE, Rooms.SERVANT_REST_ROOM),
			new Room(Rooms.SERVANT_REST_ROOM, false, Rooms.SERVANT_QUARTER, Rooms.LEFT_HALLWAY, Rooms.NONE,
					Rooms.NONE) };

	public void createAdventurer() {
		System.out.println("Before you begin your quest, please input your character's name: ");
		adventurerName = scan.nextLine();
		System.out.println(
				"You have been gifted with 15 skill points. Apply them as you wish.You will be allowed to change your blessing at the end of your creation.");
		allocateAbilities();
		adventurer = new Adventurer(adventurerName, strength, dexterity, intellegence, luck);
		System.out.println(adventurer);
	}

	public void getAdventurerCurrentRoom() {
		System.out.println("You are in the " + adventurer.getCurrentRoomName().getRoomName() + ".");

	}

	public String moveAdventurer() {
		System.out.print("Please select a direction you would like to go: ");
		return scan.nextLine();

	}

	public void checkUserMovement(String userInput) {
		if (userInput.equalsIgnoreCase("North") || userInput.equalsIgnoreCase("go North")) {
			adventurer.setPreviousRoom();
			adventurer.setCurrentRoom(map[adventurer.getCurrentRoomName().getRoomIndex()].goNorth());
		} else if (userInput.equalsIgnoreCase("South") || userInput.equalsIgnoreCase("go South")) {
			adventurer.setPreviousRoom();
			adventurer.setCurrentRoom(map[adventurer.getCurrentRoomName().getRoomIndex()].goSouth());
		} else if (userInput.equalsIgnoreCase("East") || userInput.equalsIgnoreCase("go East")) {
			adventurer.setPreviousRoom();
			adventurer.setCurrentRoom(map[adventurer.getCurrentRoomName().getRoomIndex()].goEast());
		} else if (userInput.equalsIgnoreCase("West") || userInput.equalsIgnoreCase("go West")) {
			adventurer.setPreviousRoom();
			adventurer.setCurrentRoom(map[adventurer.getCurrentRoomName().getRoomIndex()].goWest());
		}
		if (adventurer.getCurrentRoomName().equals(Rooms.NONE)) {
			adventurer.setCurrentRoom(adventurer.getPreviousRoomName());
			System.out.println("You can't find any indication of a passage in that direction.");
		}
	}

	public int gatherAbility(String userInput) {
		do {
			isValid = false;
			if (maxValue == 0) {
				System.out.println("You have used all of The God's grace, young adventurer.");
			} else if (userInput.matches("\\d+") && maxValue != 0) {
				ability = Integer.parseInt(userInput);
				if (ability <= maxValue) {
					isValid = true;
				} else if (maxValue != 0) {
					System.out.println("You may only allocate " + maxValue + " points, young adventurer.");
				}
			} else {
				System.out.println("You may only input digits, young adventurer.");
			}
			if (!isValid) {
				userInput = scan.nextLine();
			}
		} while (!isValid);
		return ability;
	}

	public void allocateAbilities() {
		do {
			System.out.print("Strength:");
			strength = gatherAbility(scan.nextLine());
			setCurrentMaxValue(strength);
			if (maxValue != 0) {
				System.out.print("Dexterity: ");

				dexterity = gatherAbility(scan.nextLine());
				setCurrentMaxValue(dexterity);
			}
			if (maxValue != 0) {
				System.out.print("Intellegence: ");
				intellegence = gatherAbility(scan.nextLine());
				setCurrentMaxValue(intellegence);
			}
			if (maxValue != 0) {
				System.out.print("Luck: ");
				luck = gatherAbility(scan.nextLine());
				setCurrentMaxValue(luck);
			} else {
				System.out.println("You have used all of The God's grace, young adventurer.");
			}
			ensureCompletion();
		} while (!done);
	}

	public void ensureCompletion() {
		do {
			System.out.println("Do you wish to keep your blessings, or recreate your own being?");
			if (maxValue != 0) {
				System.out.println(
						"You have chosen not to use all of your blessings. You may choose to disrespect The Gods so, but it is not advised.");
			}
			userInput = scan.nextLine();
			if (userInput.equalsIgnoreCase("Keep")) {
				chosen = true;
				done = true;
			} else if (userInput.equalsIgnoreCase("Recreate")) {
				chosen = true;
				maxValue = 15;
			} else {
				System.out.println("Your only options are to keep or to recreate.");
			}
		} while (!chosen);
	}

	public void setCurrentMaxValue(int abilityDecrement) {
		if (maxValue != 0 && isValid) {
			maxValue -= abilityDecrement;
		}
	}

	public void possiblySpawnEnemy() {
		if (rand.nextInt(RAND_BOUND) <= SPAWN_CHANCE) {
			World.drawDividor();
			vamp = new Vampire(Difficulty.values()[rand.nextInt(DIFFICULTY_BOUND)]);
			System.out.println("A dark being has appeared!");
			battle(adventurer, vamp);
			World.drawDividor();
		}
	}

	public void battle(Adventurer adventurer, Vampire vamp) {
		do {
			World.drawDividor();
			if (battleCounter % 2 == 0) {
				System.out.println(
						"Your health: " + adventurer.getCurrentHealth() + "\nYour stamina: " + adventurer.getStamina());
				System.out.println("Enemy health: " + vamp.getCurrentHealth());
				do {
					System.out.println("Will you attack normally or with strength?");
					attackType = scan.nextLine();
					checkForAttack(vamp);
				} while (hasNotAttacked);
				System.out.println("You did " + adventurer.getBattleDamage() + " damage to your foe.");
			} else {
				enemyAttack();
			}
			battleCounter++;
		} while (adventurer.getCurrentHealth() != 0 && vamp.getCurrentHealth() != 0);
		battleCounter = 0;
		if (adventurer.getCurrentHealth() != 0) {
			adventurer.reset();
			System.out.println("You have slain your foe!");
		}
	}

	public void checkForAttack(Vampire vamp) {
		hasNotAttacked = true;
		if (attackType.equalsIgnoreCase("Normally") || attackType.equalsIgnoreCase("Attack Normally")
				|| attackType.equalsIgnoreCase("normal Attack") || attackType.equalsIgnoreCase("normal")) {
			vamp.setCurrentHealth(adventurer.normalAttack(), true);
			hasNotAttacked = false;
		} else if (attackType.equalsIgnoreCase("Strong") || attackType.equalsIgnoreCase("Strong Attack")
				|| attackType.equalsIgnoreCase("attack with strength")
				|| attackType.equalsIgnoreCase("strength") && adventurer.getStamina() != 0) {
			vamp.setCurrentHealth(adventurer.strongAttack(vamp), true);
			adventurer.setCurrentStamina();
			hasNotAttacked = false;
		} else {
			System.out.println("You take some time trying to figure out what attack you would like...");
		}
	}

	public boolean adventurerDead() {
		return adventurer.getCurrentHealth() != 0;
	}

	public void enemyAttack() {
		attackedStrongly = false;
		if (vamp.getStamina() != 0) {
			if (rand.nextBoolean()) {
				System.out.println("Your enemy attempted a strong attack");
				adventurer.setCurrentHealth(vamp.strongAttack(adventurer), true);
				attackedStrongly = true;
			}
		}
		if (!attackedStrongly) {
			System.out.println("Your enemy attacked normally.");
			adventurer.setCurrentHealth(vamp.normalAttack(), true);
		}
		System.out.println("Your foe did " + vamp.getBattleDamage() + " damage to you.");
	}

}
