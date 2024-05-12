package strategy;
import factory.Entity;

public class FlexibleEnemyStrategy extends EnemyStrategy{

    public FlexibleEnemyStrategy(){
        this(null);
    }

    public FlexibleEnemyStrategy(Entity currentEntity) {
        super(currentEntity, new DefensiveStrategy(currentEntity));
    }

    @Override
    public void analyseHP() {
        if(currentEntity.getHP() < 3){
            // si tiene poca vida, cambia a estrategia de sanar
            this.setActionStrategy(new HealStrategy(currentEntity));
        }
    }

    @Override
    public void analyseDEF() {
        if(currentEntity.getDEF()==1){
            // si tiene full defense, cambia a estrategia de ataque
            this.setActionStrategy(new BasicAttackStrategy(currentEntity));
        }else{
            this.setActionStrategy(new DefensiveStrategy(currentEntity));
        }
    }

    @Override
    public void analyseTarget(Entity target) {
        if(target.getHP() < 3){
            // si el target tiene poca vida, cambia a estrategia de ataque para matarlo
            this.setActionStrategy(new BasicAttackStrategy(currentEntity));
        }
        if(target.getATK() > 5){
            // si el target tiene ataque alto, cambia a estrategia de defensa
            this.setActionStrategy(new DefensiveStrategy(currentEntity));
        }
    }
    
}