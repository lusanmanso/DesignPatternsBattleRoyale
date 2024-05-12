package decorator;

import factory.*;

/* Componente Concreto de Decorator: Es una clase de objetos envueltos. Define el comportamiento 
 * básico que los decoradores pueden alterar.*/
public abstract class BasicEquipment implements Equipment {

    private String name;
    private int bonus; // ATK para las armas, DEF para los shields?

    public BasicEquipment(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
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