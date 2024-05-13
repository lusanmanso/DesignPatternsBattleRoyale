package factory.enemies;
import strategy.FlexibleEnemyStrategy;

public class ForestWitch extends Witch {

    public ForestWitch(){
        super("Forest Witch", new FlexibleEnemyStrategy());
        this.getEnemyStrategy().setCurrentEntity(this);
        this.defBonus(10);
    }

}
