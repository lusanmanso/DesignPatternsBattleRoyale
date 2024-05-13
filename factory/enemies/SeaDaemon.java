package factory.enemies;
import strategy.HyperDefensiveEnemyStrategy;

public class SeaDaemon extends Daemon {

    public SeaDaemon(){
        super("Sea Daemon", new HyperDefensiveEnemyStrategy());
        this.getEnemyStrategy().setCurrentEntity(this);
        this.hpBonus(10);
        this.atkBonus(5);
    }

}