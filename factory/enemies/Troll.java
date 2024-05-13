package factory.enemies;

import factory.*;
import strategy.EnemyStrategy;

public abstract class Troll extends Enemy {
    private static final int DEFAULT_ATK = 50;
    private static final int DEFAULT_HP = 70;
    private static final double DEFAULT_DEF = 30; 

    public Troll(String name, EnemyStrategy enemyStrategy){
        this(DEFAULT_ATK, DEFAULT_HP, DEFAULT_DEF, name, enemyStrategy);
    }

    public Troll(int ATK, int HP, double DEF, String name, EnemyStrategy enemyStrategy){
        super(ATK, HP, DEF, name, null);
    }
}