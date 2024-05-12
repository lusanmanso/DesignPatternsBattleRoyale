
package strategy;
import factory.Entity;

public class HyperDefensiveEnemyStrategy extends EnemyStrategy{

    public HyperDefensiveEnemyStrategy(){
        this(null);
    }

    public HyperDefensiveEnemyStrategy(Entity currentEntity) {
        super(currentEntity, new DefensiveStrategy(currentEntity));
    }

    @Override
    public void analyseHP() {
        // nada
        return;
    }

    @Override
    public void analyseDEF() {
        // nada
        return;
    }

    @Override
    public void analyseTarget(Entity target) {
        // nada
        return;
    }

}
