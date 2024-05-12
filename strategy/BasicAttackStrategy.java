package strategy;
import factory.*;

/* Estragia concreta de Strategy
 * Componente Concreto de Decorator: Define comportamiento báscio que los decoradores pueden alterar.
 */
public class BasicAttackStrategy extends ActionStrategy {

	public BasicAttackStrategy(Entity currentEntity) {
		super(currentEntity);
	}

	public void action(Entity entity){
   		 // atacar a entity
    		int ATK = currentEntity.getATK();
    		double DEF = entity.getDEF();
    		int pain = (int) (ATK * (1 - DEF / 100.0));
			pain= Math.min(pain, entity.getHP());
    		entity.setHP(entity.getHP() - pain);
    
    		System.out.println(currentEntity.getName() + " does a basic attack to " + entity.getName() + " inflicting " + pain + " damage points and leaving the "+ entity.getName() +" with "+ entity.getHP()+" HP");
     }
	
}
