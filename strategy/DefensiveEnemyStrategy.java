package strategy;

import factory.Entity;

public class DefensiveEnemyStrategy extends EnemyStrategy{

    public DefensiveEnemyStrategy(){
        this(null);
    }

    public DefensiveEnemyStrategy(Entity currentEntity) {
        super(currentEntity, new DefensiveStrategy(currentEntity));
    }

    @Override
    public void analyseHP() {
        // nada
    }

    @Override
    public void analyseDEF() {
        if(currentEntity.getDEF()==1){
            // si tiene full defense, cambia a estrategia de ataque
            this.setActionStrategy(new BasicAttackStrategy(currentEntity));
        }
    }

    @Override
    public void analyseTarget(Entity target) {
        if(target.getHP() < 3){
            // si el target tiene poca vida, cambia a estrategia de ataque para matarlo
            this.setActionStrategy(new BasicAttackStrategy(currentEntity));
        }else{
            this.setActionStrategy(new DefensiveStrategy(currentEntity));
        }
    }
    
}
