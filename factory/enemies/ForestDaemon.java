package factory.enemies;
import strategy.FlexibleEnemyStrategy;

public class ForestDaemon extends Daemon {
	public ForestDaemon() {
		super("Forest Daemon", new FlexibleEnemyStrategy());
        this.getEnemyStrategy().setCurrentEntity(this);
		this.defBonus(10);
	}

}