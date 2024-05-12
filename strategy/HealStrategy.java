package strategy;
import factory.Entity;

public class HealStrategy extends ActionStrategy {

	public HealStrategy(Entity currentEntity) {
		super(currentEntity);
	}

	public void action(Entity entity) {
    		int healAmount = 20; // Cantidad de sanación
       	 	int newHealth = entity.getHP() + healAmount;
        	entity.setHP(newHealth);
        	System.out.println(entity.getName() + " is healing, restoring " + healAmount + "  HP ");
  	}
}
