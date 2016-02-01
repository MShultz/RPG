package Step2;

public enum Difficulty {
	EASY(Statistics.E_STRENGTH, Statistics.E_DEX, Statistics.E_INTELLEGENCE, Statistics.E_LUCK, Statistics.E_HEALTH),
	MEDIUM(Statistics.M_STRENGTH, Statistics.M_DEX, Statistics.M_INTELLEGENCE, Statistics.M_LUCK, Statistics.M_HEALTH),
	HARD(Statistics.H_STRENGTH, Statistics.H_DEX, Statistics.H_INTELLEGENCE, Statistics.H_LUCK, Statistics.H_HEALTH);
	
	
	private int strength, dexterity, intellegence, luck, health;
	
	
	private Difficulty(int strength, int dexterity, int intellegence, int luck, int health){
		this.strength = strength;
		this.dexterity = dexterity;
		this.intellegence = intellegence;
		this.luck = luck;
		this.health = health;
	}
	
	public int getStrength(){
		return strength;
	}
	public int getDexterity(){
		return dexterity;
	}
	public int getIntellegence(){
		return intellegence;
	}
	public int getLuck(){
		return luck;
	}
	public int getHealth(){
		return health;
	}
}
