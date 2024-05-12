package factory;
import strategy.*;

public abstract class Enemy extends Entity{
    private EnemyStrategy enemyStrategy;
    private int maxHP;

    public Enemy(int ATK, int HP, double DEF, String name, EnemyStrategy enemyStrategy){
        super(ATK, HP, DEF, name);
        this.maxHP = HP;
        this.enemyStrategy = enemyStrategy;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public EnemyStrategy getEnemyStrategy() {
        if (this.enemyStrategy == null) {
            enemyStrategy = new FlexibleEnemyStrategy((this));
        }
        
        return enemyStrategy;
    }
    public void setEnemyStrategy(EnemyStrategy enemyStrategy) {
        this.enemyStrategy = enemyStrategy;
    }
}