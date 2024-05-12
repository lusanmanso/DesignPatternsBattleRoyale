package decorator;

import factory.*;

// Componente del Decorator: Declara la interfaz común para wrappers como para objetos wrapeados.
public interface Equipment {
    void use(Entity target);
    public String getName();
}