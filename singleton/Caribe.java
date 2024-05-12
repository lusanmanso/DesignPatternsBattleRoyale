package singleton;

import factory.*;


public class Caribe extends World {
    
    public Caribe() {
        super("Caribe", new SeaAbstractFactory());
    }

    @Override
    public EnemyAbstractFactory createEnemyFactory() {
        return new SeaAbstractFactory();
    }
}
