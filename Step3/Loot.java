package Step3;

import java.util.Random;

public class Loot {
	Random rand = new Random();
	private static final int LOW_STRENGTH = 3;
	private static final int MED_STRENGTH = 5;
	private static final int HIGH_STRENGTH = 7;
	private static final int LOW_HEALTH_ADDITION = 10;
	private LootType lootName;
	private int strength, healthAddition;
	
	public Loot(LootType loot){
		this.lootName = loot;
		determineLootStrength(lootName);
		determineLootHealthAddition(lootName);
		
	}
	
	private void determineLootStrength(LootType loot){
		switch(loot){
		case DAGGER:
			strength = rand.nextInt(LOW_STRENGTH);
			break;
		case SHIELD:
			strength = rand.nextInt(MED_STRENGTH) + LOW_STRENGTH;
			break;
		case SWORD:
			strength = rand.nextInt(HIGH_STRENGTH) + LOW_STRENGTH;
			break;
		case GOLD:
		case BONE_FRAGMENTS:
		case HEALTH_POTION:
			strength = 0;
			break;
		}
	}
	private void determineLootHealthAddition(LootType loot){
		if(loot.equals("HEALTH_POTION")){
			healthAddition = LOW_HEALTH_ADDITION;
		}
		else{
			healthAddition = 0;
		}
	}
	public int getStrength(){
		return strength;
	}
	public int getHealthAddition(){
		return healthAddition;
	}

	public LootType getLootType(){
		return lootName;
	}
	@Override
	public String toString() {
		return lootName.getLootName() + "\nStrength: " + strength + "\nHealth Qualities: " + healthAddition;
	}
}
