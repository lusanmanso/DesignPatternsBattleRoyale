package decorator;

import factory.*;

/* Decorador Concreto de Decorator: Define funcionalidades adicionales que se pueden añadir
 * dinámicamente a las weapons. 
 */
public class EnchantedWeapon extends EquipmentDecorator {

    public EnchantedWeapon(Equipment decoratedWeapon) {
        super(decoratedWeapon);
    }

    @Override
    public void use(Entity target) {
        System.out.println("Enchanting the weapon.");
        super.use(target);
    }

    private void addEnchantment() {
        System.out.println("The weapon glows with a mystical aura.");
    }

    public String getName() {
        return decoratedWeapon.getName();
    }
    
}
