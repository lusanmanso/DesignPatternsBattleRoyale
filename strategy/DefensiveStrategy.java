package strategy;

import factory.Entity;

public class DefensiveStrategy extends ActionStrategy{

    public DefensiveStrategy(Entity currentEntity) {
        super(currentEntity);
    }

      public void action(Entity entity) {
        // defenderse
        int bonusDefense=10;
        double newDefense=entity.getDEF()+bonusDefense;
        entity.setDEF(newDefense);
        System.out.println(entity.getName()+" defends themselves");
    }

}
