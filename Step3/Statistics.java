package Step3;

public class Statistics {
	protected final static int E_STRENGTH = 4;
	protected final static int E_DEX = 4;
	protected final static int E_INTELLEGENCE = 3;
	protected final static int E_LUCK = 4;
	protected final static int E_HEALTH = 20;
	protected final static int M_STRENGTH = 5;
	protected final static int M_DEX = 5;
	protected final static int M_INTELLEGENCE = 0;
	protected final static int M_LUCK = 5;
	protected final static int M_HEALTH = 30;
	protected final static int H_STRENGTH = 6;
	protected final static int H_DEX = 4;
	protected final static int H_INTELLEGENCE = 8;
	protected final static int H_LUCK = 6;
	protected final static int H_HEALTH = 40;
	public int strength, dexterity, intellegence, luck;
	
	
	public Statistics(int strength, int dexterity, int intellegence, int luck){
		this.strength = strength;
		this.dexterity = dexterity;
		this.intellegence = intellegence;
		this.luck = luck;
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
	
	
}
