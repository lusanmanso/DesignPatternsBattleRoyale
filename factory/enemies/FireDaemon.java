package factory.enemies;

import strategy.HyperAggressiveEnemyStrategy;

public class FireDaemon extends Daemon {
	public FireDaemon() {
		super("Fire Daemon", new HyperAggressiveEnemyStrategy());
        this.getEnemyStrategy().setCurrentEntity(this);
		this.atkBonus(10);
		this.hpBonus(20);
	}

}
