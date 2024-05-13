package factory.enemies;
import strategy.HyperDefensiveEnemyStrategy;

public class SeaTroll extends Troll {

    public SeaTroll(){
        super("Sea Troll", new HyperDefensiveEnemyStrategy());
        this.getEnemyStrategy().setCurrentEntity(this);
        this.hpBonus(10);
        this.atkBonus(5);
    }

}