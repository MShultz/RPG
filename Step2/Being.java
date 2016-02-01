package Step2;

import java.util.Random;

public abstract class Being extends Statistics {
	private final static double DEX_CHANCE = 0.50;
	private final static int STAMINA_COST = 2;
	public final static int DAMAGE_CALC = 5 ; 
	private int damage;
	private boolean strongAttacked = false;
	private Random rand = new Random();

	public Being(int strength, int dexterity, int intellegence, int luck) {
		super(strength, dexterity, intellegence, luck);
	}

	public int getNewHealth(int beingHealth, int healthNum, boolean isDamage) {
		if (beingHealth >= 180 && !isDamage) {
			System.out.println("Your adventurer has maximum health");
		} else if (beingHealth - healthNum < 0 && isDamage) {
			beingHealth = 0;
		} else {
			beingHealth = (isDamage ? beingHealth - healthNum : beingHealth + healthNum);
		}
		return beingHealth;
	}

	public int getCurrentStamina(int stamina) {
		if (strongAttacked) {
			return (stamina - STAMINA_COST >= 0 ? stamina - STAMINA_COST : 0);
		} else {
			return stamina;
		}

	}

	public int normalAttack() {
		
		damage = (this.getLuck() != 0?(this.getStrength() + rand.nextInt(this.getLuck())): this.getStrength()-DAMAGE_CALC);
		return damage;
	}

	public int strongAttack(Being enemy) {
		if ((this.getLuck() * rand.nextDouble())
				+ (this.getDexterity() * DEX_CHANCE) > (enemy.getDexterity() * DEX_CHANCE
						+ (enemy.getLuck() * rand.nextDouble()))) {
			strongAttacked = true;
			damage = (this.getStrength() * (rand.nextInt(this.getStrength())) + this.getDexterity());
			System.out.println("The attack landed.");
		} else {
			System.out.println("The attack was dodged.");
			damage = 0;
		}
		return damage;
	}

	public int getBattleDamage() {
		return damage;
	}

	public abstract void setCurrentHealth(int healthNum, boolean isDamage);

	public abstract void setCurrentStamina();

	public abstract int getCurrentHealth();

}
