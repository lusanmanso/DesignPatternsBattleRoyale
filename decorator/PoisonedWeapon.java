package decorator;

import state.*;
import factory.*;

public class PoisonedWeapon extends EquipmentDecorator {

    public PoisonedWeapon(BasicEquipment decoratedWeapon) {
        super(decoratedWeapon);
    }

    public void use(Entity target) {
        System.out.println("Adding poison to the weapon.");
        EntityState poisonedState = new PoisonedState();
        target.setCurrentState(poisonedState);
        target.applyEffect();
        super.use(target);
    }

    private void addPoison() {
        System.out.println(decoratedWeapon.getName() + " glows a vibrant green.");
    }

    public String getName() {
        return decoratedWeapon.getName();
    }
}
