package factory;

import factory.enemies.*;

public class VolcanoAbstractFactory implements EnemyAbstractFactory {

    @Override
    public Witch createWitch() {
        return new FireWitch();
    }

    @Override
    public Daemon createDaemon() {
        return new FireDaemon();
    }

    @Override
    public Troll createTroll() {
        return new FireTroll();
    }
    
}