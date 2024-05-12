package strategy;
import factory.*;

public class DoNothingStrategy extends ActionStrategy {

	public DoNothingStrategy(Entity currentEntity) {
		super(currentEntity);
	}

	public void action(Entity entity) {
		System.out.println(currentEntity.getName() + " does nothing and skips their turn.");
	}

}
