package factory.enemies;

import factory.Enemy;
import strategy.*;

// Daemon.java
public abstract class Daemon extends Enemy {
    private static final int DEFAULT_ATK = 70;
    private static final int DEFAULT_HP = 40;
    private static final double DEFAULT_DEF = 40;

    public Daemon(String name, EnemyStrategy enemyStrategy){
        this(DEFAULT_ATK, DEFAULT_HP, DEFAULT_DEF, name, enemyStrategy);
    }

    public Daemon(int ATK, int HP, double DEF, String name, EnemyStrategy enemyStrategy){
        super(ATK, HP, DEF, name, null);
    }
}