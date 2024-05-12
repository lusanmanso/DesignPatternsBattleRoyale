package singleton;

import java.util.ArrayList;
import java.util.List;

import factory.*;
import factory.enemies.*;

public class WorldManager {
    
    private EnemyAbstractFactory enemyAbstractFactory;
    private World currentWorld;
    private List<World> worlds = new ArrayList<>();

    private static WorldManager worldManager = new WorldManager();
    
    private WorldManager() {}

    public static WorldManager getInstance() {
        return worldManager;
    }

    public void setCurrentWorld(World world) {
        this.currentWorld = world;
    }

    public World getCurrentWorld() {
        return this.currentWorld;
    }

    public void addWorld(World world) {
        worlds.add(world);
    }

    public List<World> getWorlds() {
        return worlds;
    }

    public Witch createWitch() {
        return this.enemyAbstractFactory.createWitch(); // Implementación según el mundo actual
    }

    public Daemon createDaemon() {
        return this.enemyAbstractFactory.createDaemon();
    }
}
