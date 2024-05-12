package singleton;

import factory.*;

import java.util.List;
import java.util.ArrayList;

public abstract class World {

    private List<Enemy> enemies = new ArrayList<>();
    private String name;
    private EnemyAbstractFactory enemyFactory;

    public World(String name, EnemyAbstractFactory enemyFactory){
        this.name = name;
        this.enemyFactory = enemyFactory;
    }

    public void addEnemy(String type) {
        switch(type){
            case "Witch":
                enemies.add(enemyFactory.createWitch());
                break;
            case "Daemon":
                enemies.add(enemyFactory.createDaemon());
                break;
            case "Troll":
            default:
                throw new IllegalArgumentException("Invalid enemy type" + type);
        }
    }

    public EnemyAbstractFactory getEnemyFactory() {
        return enemyFactory;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public String getName() {
        return name;
    }
    public abstract EnemyAbstractFactory createEnemyFactory();
}
