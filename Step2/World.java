package Step2;

public class World {

	private static boolean adventurerAlive = true;
	public static final String DIVIDOR = "--------------------------";

	public static void main(String[] args) {
		Castle castle = new Castle();
		drawDividor();
		castle.createAdventurer();
		drawDividor();
		do {
			castle.getAdventurerCurrentRoom();
			castle.checkUserMovement(castle.moveAdventurer());
			castle.possiblySpawnEnemy();
			adventurerAlive = castle.adventurerDead();
		} while (adventurerAlive);
		
		System.out.println("You have been slain.");
	}
	
	public static void drawDividor(){
		System.out.println();
		System.out.println(DIVIDOR);
		System.out.println();
	}
}