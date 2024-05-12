package decorator;

import state.*;
import factory.*;

public class PoisonedWeapon extends WeaponDecorator {

    public PoisonedWeapon(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    public void use(Entity target) {
        System.out.println("Envenenando el arma.");
        EntityState poisonedState = new PoisonedState();
        target.setCurrentState(poisonedState);
        target.applyEffect();
        super.use(target);
    }

    private void addPoison() {
        System.out.println("El arma destella con un verde brillante.");
    }
}
