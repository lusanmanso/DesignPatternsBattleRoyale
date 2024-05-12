


package factory;
import factory.enemies.*;


public class ForestAbstractFactory implements EnemyAbstractFactory {

    @Override
    public Witch createWitch() {
        return new ForestWitch();
    }

    @Override
    public Daemon createDaemon() {
        return new ForestDaemon();
    }

    @Override
    public Troll createTroll() {
        return new ForestTroll();
    }
    
}
