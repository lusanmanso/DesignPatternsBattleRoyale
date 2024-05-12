
package factory;
import factory.enemies.*;


public class SeaAbstractFactory implements EnemyAbstractFactory {

    @Override
    public Witch createWitch() {
        return new SeaWitch();
    }

    @Override
    public Daemon createDaemon() {
        return new SeaDaemon();
    }

    @Override
    public Troll createTroll() {
        return new SeaTroll();
    }
    
}
