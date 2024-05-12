package extra;

import java.util.Scanner;

import facade.BattleManager;


public class PlayerInput {

    private BattleManager battleManager;

    public PlayerInput(EnemyManager enemyManager) {
        this.battleManager = new BattleManager(enemyManager, player);
    }

    public void actionMenu() {
        battleManager.actionMenu();
    }

    public void chosenAction(int choice) {
        battleManager.chosenAction(choice);
    }

    public Player getPlayer() {
        return player;
    }
}
