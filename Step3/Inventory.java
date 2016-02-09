package Step3;

import java.util.HashMap;
import java.util.Map;

import Step3.Loot;

public class Inventory {
	private Map<LootType, Integer> inventory;

	public Inventory() {
		inventory = new HashMap<LootType, Integer>();
	}

	public void addToInventory(Map<LootType, Integer> gatheredLoot) {
		if (inventory.isEmpty()) {
			inventory = gatheredLoot;
		} else {
			for (LootType key : gatheredLoot.keySet()) {
				if (inventory.containsKey(key)) {
					inventory.put(key, inventory.get(key) + gatheredLoot.get(key));
				} else {
					inventory.put(key, gatheredLoot.get(key));
				}
			}
		}
	}

	protected void printContents() {
		if (inventory.isEmpty()) {
			System.out.println("There doesn't seem to be anything in your inventory.");
		} else {

			System.out.println("Your inventory currently contains: \n");
			for (LootType key : inventory.keySet()) {
				System.out.println(inventory.get(key) + " " + key.getLootName()
						+ (inventory.get(key) > 1 && !key.equals(LootType.GOLD) ? "s\n":"\n" ));
			}
		}
	}
}