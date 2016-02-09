package Step3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public enum Rarity {
	ULTRA_COMMON("Ultra Common"), COMMON("Common"), UNCOMMON("Uncommon"), RARE("Rare"), ULTRA_RARE("Ultra Rare"), EPIC(
			"Epic");

	Random rand = new Random();
	private static final int ONE = 1;
	private static final int FEW = 3;
	private static final int SOME = 5;
	private static final int MANY = 10;
	private String rarityType;
	private Map<LootType, Integer> currentLoot = new HashMap<LootType, Integer>();

	private Rarity(String commonType) {
		this.rarityType = commonType;

		switch (rarityType) {
		case "Ultra Common":
			setUltraCommonBag();
			break;
		case "Common":
			setCommonBag();
			break;
		case "Uncommon":
			setUncommonBag();
			break;
		case "Rare":
			setRareBag();
			break;
		case "Ultra Rare":
			setUltraRareBag();
			break;
		case "Epic":
			setEpicBag();
			break;
		}
	}

	private void setUltraCommonBag() {
		currentLoot.put(new Loot(LootType.BONE_FRAGMENTS).getLootType(), rand.nextInt(SOME)+ ONE);
		currentLoot.put(new Loot(LootType.GOLD).getLootType(), rand.nextInt(FEW) + ONE);
	}

	private void setCommonBag() {
		currentLoot.put(new Loot(LootType.GOLD).getLootType(), rand.nextInt(SOME) + FEW);
		currentLoot.put(new Loot(LootType.HEALTH_POTION).getLootType(), ONE);
	}

	private void setUncommonBag() {
		currentLoot.put(new Loot(LootType.HEALTH_POTION).getLootType(), ONE);
		currentLoot.put(new Loot(LootType.SHIELD).getLootType(), ONE);
		currentLoot.put(new Loot(LootType.BONE_FRAGMENTS).getLootType(), rand.nextInt(MANY) + ONE);
	}

	private void setRareBag() {
		setUncommonBag();
		currentLoot.put(new Loot(LootType.DAGGER).getLootType(), ONE);
		currentLoot.remove(LootType.SHIELD);
	}

	private void setUltraRareBag() {
		currentLoot.put(new Loot(LootType.HEALTH_POTION).getLootType(), FEW);
		currentLoot.put(new Loot(LootType.SWORD).getLootType(), ONE);
		currentLoot.put(new Loot(LootType.GOLD).getLootType(), rand.nextInt(MANY) + SOME);
	}
	private void setEpicBag(){
		setUltraRareBag();
		currentLoot.remove(LootType.HEALTH_POTION);
		currentLoot.put(new Loot(LootType.HEALTH_POTION).getLootType(), SOME);
		
	}
	public Map<LootType, Integer> getContents(){
		return currentLoot;
	}
	public String getRarityType(){
		return rarityType;
	}
}
