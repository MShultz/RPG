package Step2;

public class Vampire extends Being {
	public String enemyName;
	public int enemyHealth, stamina;
	
	public Vampire(Difficulty difficulty){
		super(difficulty.getStrength(), difficulty.getDexterity(), difficulty.getIntellegence(), difficulty.getLuck());
		enemyName = "Vampire";
		enemyHealth = difficulty.getHealth();
		stamina = 8;
		
	}

	@Override
	public void setCurrentHealth(int healthNum, boolean isDamage) {
		enemyHealth = this.getNewHealth(enemyHealth, healthNum, isDamage);
		
	}

	@Override
	public void setCurrentStamina() {
		stamina = this.getCurrentStamina(stamina);
		
	}

	@Override
	public int getCurrentHealth() {
		return enemyHealth;
	}
	
	public String getEnemyName(){
		return enemyName;
	}
	public int getStamina() {
		return stamina;
	}

}
