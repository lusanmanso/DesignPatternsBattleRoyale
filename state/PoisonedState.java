package state;

import factory.*;

public class PoisonedState implements EntityState {

    private int turnsLeft = 0; // Duración en turnos del estado

    @Override
    public void applyEffect(Entity entity) {
        
        if(turnsLeft==0){
            System.out.println(entity.getName() + " has been hit with poison, and they will remain poisoned for two turns. Their defense lowers by two points.");
            turnsLeft = 2;
            entity.defBonus(-2); // Le bajan las defensas cuando está envenenado
        }else{
            System.out.println(entity.getName() + " has been poisoned again. Their turns poisoned increase by one.");
            entity.defBonus(-1);
        }
            
    }

    @Override
    public void updateState(Entity entity) {
        turnsLeft--; 
        if (turnsLeft <= 0) {
            System.out.println(entity.getName() + " is not poisoned anymore. Their defense increases by two again, returning to normal.");
            entity.defBonus(2);
            entity.setCurrentState(entity.getNormalState());
            turnsLeft = 0; // Reset
        }
    }
    
}
