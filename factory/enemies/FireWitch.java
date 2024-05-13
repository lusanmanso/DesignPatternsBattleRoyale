package factory.enemies;
import strategy.HyperAggressiveEnemyStrategy;

public class FireWitch extends Witch {

    public FireWitch(){
        super("Fire Witch", new HyperAggressiveEnemyStrategy());
        this.getEnemyStrategy().setCurrentEntity(this);
        this.atkBonus(10);
        this.hpBonus(20);
    }

}