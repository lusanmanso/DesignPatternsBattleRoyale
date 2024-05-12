package strategy;
import factory.*;


public class AddWeaponStrategy extends ActionStrategy{

	// private Entity currentEntity;
	
	public AddWeaponStrategy(Entity currentEntity) {
		super(currentEntity);
	}

	public void action(Entity entity) {
		int bonusAttack = 15; // Incremento de ataque al agregar un arma
        int newAttack = entity.getATK() + bonusAttack;
        entity.setATK(newAttack);
        System.out.println(entity.getName() + " se hace con un arma incrementando su ataque a "+entity.getATK());
    }
}
