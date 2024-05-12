package singleton;

import factory.*;


public class Jumanji extends World {

    public Jumanji() {
        super("Jumanji", new ForestAbstractFactory());
    }

    @Override
    public EnemyAbstractFactory createEnemyFactory() {
        return new ForestAbstractFactory();
    }
    
}
