package factory;

import factory.enemies.*;

public interface EnemyAbstractFactory {
	public Witch createWitch();
	public Daemon createDaemon();
	public Troll createTroll();
}
