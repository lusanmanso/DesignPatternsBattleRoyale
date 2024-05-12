package decorator;

import strategy.ActionStrategy;
import factory.Entity;

/* Decorador concreto */
public class EnhancedDamageDecorator extends ActionDecorator {
    
    public EnhancedDamageDecorator(ActionStrategy decoratedAction) {
        super(decoratedAction);
    }

    @Override
    public void action(Entity target) {
        System.out.println("Increasing the attack value.");
        super.action(target);
    }
}
