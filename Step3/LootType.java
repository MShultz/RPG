package Step3;

public enum LootType {
	DAGGER("Dagger"), SWORD("Sword"), GOLD("Gold"), SHIELD("Shield"), BONE_FRAGMENTS("Bone Fragment"), HEALTH_POTION(
			"Health Potion");

	private String lootName;

	private LootType(String name) {
		this.lootName = name;
	}

	public String getLootName() {
		return lootName;
	}

}
