package factory.enemies;
import strategy.FlexibleEnemyStrategy;

public class ForestTroll extends Troll {
	public ForestTroll() {
		super("Forest Troll", new FlexibleEnemyStrategy());
        this.getEnemyStrategy().setCurrentEntity(this);
		this.defBonus(10);
	}

}