package strategy;

import factory.Entity;

/* Clase abstracta de estrategias de enemigos */
public abstract class EnemyStrategy extends ActionStrategy {
    private ActionStrategy actionStrategy;

	public EnemyStrategy(){
		this(null, null);
	}

    public EnemyStrategy(Entity currentEntity, ActionStrategy actionStrategy) {
        super(currentEntity);
        this.actionStrategy = actionStrategy;
    }

    @Override
    public void action(Entity target) {
        actionStrategy.action(target);
    }

	// TEMPLATE PATTERN -----------------------------------
	public abstract void analyseHP();
	public abstract void analyseDEF();
	public abstract void analyseTarget(Entity target);

	public void enemyAction(Entity target){
		analyseHP();
		analyseDEF();
		analyseTarget(target);
		action(target);
	}
	// TEMPLATE PATTERN -----------------------------------

	// GETTERS AND SETTERS ----------------------------------------
	public ActionStrategy getActionStrategy(){
		return this.actionStrategy;
	}
    public void setActionStrategy(ActionStrategy actionStrategy) {
        this.actionStrategy = actionStrategy;
    }
	// GETTERS AND SETTERS ----------------------------------------
}