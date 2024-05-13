package factory.enemies;

import strategy.HyperDefensiveEnemyStrategy;

public class SeaWitch extends Witch {

    public SeaWitch(){
        super("Sea Witch", new HyperDefensiveEnemyStrategy());
        this.getEnemyStrategy().setCurrentEntity(this);
        this.hpBonus(10);
        this.atkBonus(5);
    }

}