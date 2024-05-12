package decorator;

import factory.*;

/* Decorador Concreto de Decorator: Define funcionalidades adicionales que se pueden añadir
 * dinámicamente a las weapons. 
 */
public class EnchantedWeapon extends WeaponDecorator {

    public EnchantedWeapon(Weapon decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public void use(Entity target) {
        System.out.println("Encantando el arma.");
        super.use(target);
    }

    private void addEnchantment() {
        System.out.println("El arma brila con una mística aura.");
    }
    
}
