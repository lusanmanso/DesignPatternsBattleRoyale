package decorator;

import factory.*;

/* Componente Concreto de Decorator: Es una clase de objetos envueltos. Define el comportamiento 
 * básico que los decoradores pueden alterar.*/
public class BasicWeapon implements Weapon {

    private String name;

    public BasicWeapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void use(Entity target) {
        System.out.println(name + "used on " + target.getName());
    }

}