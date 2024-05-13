package factory.enemies;

import factory.Enemy;
import factory.Entity;
import strategy.*;

public abstract class Daemon extends Enemy {
    private static final int DEFAULT_ATK = 60;
    private static final double DEFAULT_DEF = 30; // Tiene mejor ataque. Peor defensa
    
    public Daemon(String name, EnemyStrategy enemyStrategy){
        this(DEFAULT_ATK, Entity.DEFAULT_HP, DEFAULT_DEF, name, enemyStrategy);
    }

    public Daemon(int ATK, int HP, double DEF, String name, EnemyStrategy enemyStrategy){
        super(ATK, HP, DEF, name, null);
    }
}