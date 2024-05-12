package strategy;

import factory.*;

/* Abstracta como Interfaz del Strategy para todas las entidades en el juego. 
 * A su vez es el componente de Decorator (define la operación action() que 
 * tanto los decoradores como los componentes concretos deben implementar. */
public abstract class ActionStrategy {
	
	protected Entity currentEntity;
	
	public ActionStrategy(Entity currentEntity) {
		this.currentEntity = currentEntity;
	}
	
	public void setCurrentEntity(Entity currentEntity) {
		this.currentEntity = currentEntity;
	}
	public Entity getCurrentEntity() {
		return this.currentEntity;
	}
	
	public abstract void action(Entity target);
}
