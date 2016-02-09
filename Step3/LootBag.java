package Step3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LootBag {
	
	private final static int ULTRA_COMMON_BOUND = 500;
	private final static int COMMON_BOUND = 750;
	private final static int UNCOMMON_BOUND = 875;
	private final static int RARE_BOUND = 950;
	private final static int ULTRA_RARE_BOUND = 999;
	private final static int EPIC_BOUND = 1000;
	private int lootNum;
	private Map<LootType, Integer> loot = new HashMap<LootType, Integer>();
	private Rarity rareType;

	public LootBag(int lootNum) {
		this.lootNum = lootNum;
		determineLootBag();
		loot = rareType.getContents();
		
	}
	public LootBag(){
		
	}

	private void determineLootBag() {
		

		if (lootNum >= 0 && lootNum <= ULTRA_COMMON_BOUND) {
			rareType = Rarity.ULTRA_COMMON;
		} else if (lootNum > ULTRA_COMMON_BOUND && lootNum <= COMMON_BOUND) {
			rareType = Rarity.COMMON;
		} else if (lootNum > COMMON_BOUND && lootNum <= UNCOMMON_BOUND) {
			rareType = Rarity.UNCOMMON;
		} else if (lootNum > UNCOMMON_BOUND && lootNum <= RARE_BOUND) {
			rareType = Rarity.RARE;
		} else if (lootNum > RARE_BOUND && lootNum <= ULTRA_RARE_BOUND) {
			rareType = Rarity.ULTRA_RARE;
		} else if (lootNum == EPIC_BOUND) {
			rareType = Rarity.EPIC;
		}
	}

	public void printContents(boolean isInventory) {
		if (isInventory) {
			if (loot.isEmpty()) {
				System.out.println("There doesn't seem to be anything in your inventory.");
			} else {
				System.out.println("Your inventory currently contains: \n");
			}
		} else {
			System.out.println("You gathered the " + rareType.getRarityType() + " loot bag that contains:\n");
		}
		for (LootType key : loot.keySet()) {
			System.out.println(loot.get(key) + " " + key.getLootName()
					+ (loot.get(key) > 1 && !key.equals(LootType.GOLD) ? "s\n" : "\n"));
		}
	}

	public Map<LootType, Integer> getLootMap() {
		return loot;
	}
	public void addToInventory(Map<LootType, Integer> gatheredLoot) {
		if (loot.isEmpty()) {
			loot = gatheredLoot;
		} else {
			for (LootType key : gatheredLoot.keySet()) {
				if (loot.containsKey(key)) {
					loot.put(key, loot.get(key) + gatheredLoot.get(key));
				} else {
					loot.put(key, gatheredLoot.get(key));
				}
			}
		}
	}

}
