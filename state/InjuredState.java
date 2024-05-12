package state;

import factory.*;

public class InjuredState implements EntityState {

    @Override
    public void applyEffect(Entity entity) {
        System.out.println(entity.getName() + " has been heavily injured, and they will remain weak until they heal. Their attack lowers by two points.");
        entity.atkBonus(-2); // Le bajan las defensas cuando está envenenado
            
    }

    @Override
    public void updateState(Entity entity) {
        if(entity.getHP()>Entity.DEFAULT_LOWHP){
            System.out.println(entity.getName() + " is not heavily injured anymore and returns to their normal state. Their attack increases again by two points.");
            entity.atkBonus(2);
            entity.setCurrentState(entity.getNormalState());
        }
    }
    
}
