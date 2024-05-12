package state;

import factory.*;

public class NormalState implements EntityState {
    
    @Override
    public void applyEffect(Entity entity) {
        System.out.println(entity.getName() + " is chilling.");
    }

    

    @Override
    public void updateState(Entity entity) {
        if(entity.getHP()<=Entity.DEFAULT_LOWHP){
            entity.setCurrentState(entity.getInjuredState());
        }
    }   
}
