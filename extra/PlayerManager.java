package extra;

import java.util.InputMismatchException;
import java.util.Scanner;

import strategy.*;
import factory.*;

public class PlayerManager {

    private Scanner scanner;
    private EnemyManager enemyManager;

    Player player = new Player();

    public PlayerManager(EnemyManager enemyManager) {
        this.scanner = new Scanner(System.in);
        this.enemyManager = enemyManager;
    }

    public void actionMenu() {
        Narrator narrator = new Narrator();

        while (player.getHP() > 0 && enemyManager.areEnemiesRemaining()) {
            try {
                checkEnemyHealth();

                if (!enemyManager.areEnemiesRemaining()) {
                    break; // No more enemies remaining, exit the loop
                }
                

                
                
                // Mostrar información del enemigo actual
                if (enemyManager.getCurrentEnemy() != null) {
                    System.out.println("A " + enemyManager.getCurrentEnemy().getName() + " approaches with " + enemyManager.getCurrentEnemy().getHP() + " HP");
                    narrator.addText("What will you do? \n1. Attack\n2. Defend\n3. Heal\n4. Nothing ");
                    narrator.startNarration();
                    int choice = scanner.nextInt();
                    chosenAction(choice);
                    // Trigger enemy's attack if its HP is not 0
                    if (enemyManager.getCurrentEnemy().getHP() > 0) {
                        enemyManager.performEnemyAction(enemyManager.getCurrentEnemy(), player);
                    }
                    
                }
    
            } catch (InputMismatchException e) {
                System.out.println("Please introduce a valid option.");
                scanner.nextLine(); // Discard the incorrect input
            }
        }
    }

    private void checkEnemyHealth() {
        Enemy currentEnemy = enemyManager.getCurrentEnemy();
        
         if (currentEnemy == null) {
            System.out.println("You have defeated this world's enemy.");
            enemyManager.moveToNextEnemy(); // Avanzar al siguiente enemigo o mundo
            return;
        }

        
        int enemyHP = currentEnemy.getHP();
        
        if (enemyHP <= 0) {

            

            System.out.println(currentEnemy.getName() + " has died! You won!");

            enemyManager.moveToNextEnemy(); // Avanzar al siguiente enemigo o mundo
            currentEnemy = enemyManager.getCurrentEnemy();
        }
    }

    public void chosenAction(int choice) {
        Enemy currentEnemy = enemyManager.getCurrentEnemy();
        if (currentEnemy == null) {
            System.out.println("There is no currentEnemy in chosenAction.");
            return;
        }
       // while (currentEnemy.getHP()>=0){
        if (choice == 1) {
            player.setActionStrategy(new BasicAttackStrategy(player));
            player.executeAction(currentEnemy);
        } else if (choice == 2) {
            player.setActionStrategy(new DefensiveStrategy(player));
            player.executeAction(player);
        } else if (choice == 3) {
            player.setActionStrategy(new HealStrategy(player));
            player.executeAction(player);
        } else if (choice == 4) {
            player.setActionStrategy(new DoNothingStrategy(player));
            player.executeAction(currentEnemy);
        }
        //}
    }
    public Player getPlayer() {
        return player;
    }
}
