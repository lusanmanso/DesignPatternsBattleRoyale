package strategy;
import factory.Entity;

public class AggressiveEnemyStrategy extends EnemyStrategy{

    public AggressiveEnemyStrategy(){
        this(null);
    }

    public AggressiveEnemyStrategy(Entity currentEntity) {
        super(currentEntity, new BasicAttackStrategy(currentEntity));
    }

    @Override
    public void analyseHP() {
        if(currentEntity.getHP() < 3){
            // si tiene poca vida, cambia a estrategia defensiva
            this.setActionStrategy(new DefensiveStrategy(currentEntity));
        }else{
            this.setActionStrategy(new BasicAttackStrategy(currentEntity));
        }
    }

    @Override
    public void analyseDEF() {
        return;
    }

    @Override
    public void analyseTarget(Entity target) {
        // Implement the missing method
        // TODO: Add implementation here
    }
    
    @Override
    public void action(Entity entity) {
        // Implement the missing method
        // TODO: Add implementation here
    }
}
