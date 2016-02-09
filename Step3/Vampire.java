package Step3;

public class Vampire extends Being {
	private static final int STAMINA = 8;
	public static String enemyName = "Vampire";
	public int enemyHealth;

	public Vampire(Difficulty difficulty) {
		super(difficulty.getStrength(), difficulty.getDexterity(), difficulty.getIntellegence(), difficulty.getLuck(),
				difficulty.getHealth(), STAMINA, enemyName);
	}

}
