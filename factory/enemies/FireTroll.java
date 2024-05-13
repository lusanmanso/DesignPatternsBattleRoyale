package factory.enemies;

import strategy.HyperAggressiveEnemyStrategy;

public class FireTroll extends Troll {
	public FireTroll() {
		super("Fire Troll", new HyperAggressiveEnemyStrategy());
        this.getEnemyStrategy().setCurrentEntity(this);
		this.atkBonus(10);
		this.hpBonus(20);
	}

}