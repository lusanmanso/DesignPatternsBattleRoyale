package strategy;
import factory.Entity;

public class HyperAggressiveEnemyStrategy extends EnemyStrategy{

    public HyperAggressiveEnemyStrategy(){
        this(null);
    }

    public HyperAggressiveEnemyStrategy(Entity currentEntity) {
        super(currentEntity, new BasicAttackStrategy(currentEntity));
    }
    
    @Override
    public void action(Entity entity){
        if(currentEntity.getHP() >= 1){
            setActionStrategy(new BasicAttackStrategy(currentEntity));
        }else{
            setActionStrategy(new DefensiveStrategy(currentEntity));
        }
        super.action(entity);
    }

    @Override
    public void analyseHP() {
        return;
    }

    @Override
    public void analyseDEF() {
        return;
    }

    @Override
    public void analyseTarget(Entity target) {
        return;
    }

}
