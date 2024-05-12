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
        System.out.println("Aumentando el daño del ataque.");
        super.action(target);
    }
}
