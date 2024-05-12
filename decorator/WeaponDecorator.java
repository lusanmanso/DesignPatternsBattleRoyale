package decorator;

import factory.*;

/* Decoradora Base de Decorator: El tipo de campo debe declararse como la interfaz del componente 
 * para que pueda contener tanto componentes concretos como decoradores.*/
public abstract class WeaponDecorator implements Weapon {
    // Tiene una referencia al objeto envuelto.
    protected Weapon decoratedWeapon;

    public WeaponDecorator(Weapon decoratedWeapon) {
        this.decoratedWeapon = decoratedWeapon;
    }

    public Weapon getDecoratedWeapon() {
        return decoratedWeapon;
    }

    public void setDecoratedWeapon(Weapon decoratedWeapon) {
        this.decoratedWeapon = decoratedWeapon;
    }

    // La clase decoradora base delega todas las operaciones al objeto envuelto. 
    @Override
    public void use(Entity target) {
        decoratedWeapon.use(target);
    }
}