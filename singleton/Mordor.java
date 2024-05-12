package singleton;

import factory.*;
public class Mordor extends World {

    public Mordor() {
        super("Mordor", new VolcanoAbstractFactory());
    }

    @Override
    public EnemyAbstractFactory createEnemyFactory() {
        return new VolcanoAbstractFactory();
    }   
}
