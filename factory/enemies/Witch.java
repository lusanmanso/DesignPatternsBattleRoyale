package factory.enemies;

import factory.*;
import strategy.EnemyStrategy;

public abstract class Witch extends Enemy {
    private static final int DEFAULT_ATK = 40; 
    private static final double DEFAULT_DEF = 40;

    public Witch(String name, EnemyStrategy enemyStrategy){
        this(DEFAULT_ATK, Entity.DEFAULT_HP, DEFAULT_DEF, name, enemyStrategy);
    }

    public Witch(int ATK, int HP, double DEF, String name, EnemyStrategy enemyStrategy){
        super(ATK, HP, DEF, name, null);
    }
}