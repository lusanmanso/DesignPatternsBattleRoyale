package decorator;

import factory.*;

/* Decoradora Base de Decorator: El tipo de campo debe declararse como la interfaz del componente 
 * para que pueda contener tanto componentes concretos como decoradores.*/
public abstract class EquipmentDecorator implements Equipment {
    // Tiene una referencia al objeto envuelto.
    protected Equipment decoratedWeapon;

    public EquipmentDecorator(Equipment decoratedWeapon) {
        this.decoratedWeapon = decoratedWeapon;
    }

    public Equipment getDecoratedWeapon() {
        return decoratedWeapon;
    }

    public void setDecoratedWeapon(Equipment decoratedWeapon) {
        this.decoratedWeapon = decoratedWeapon;
    }

    // La clase decoradora base delega todas las operaciones al objeto envuelto. 
    @Override
    public void use(Entity target) {
        decoratedWeapon.use(target);
    }
}