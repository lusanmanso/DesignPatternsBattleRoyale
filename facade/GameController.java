package facade;

import java.util.ArrayList;
import java.util.List;

import extra.*;
import singleton.*;
public class GameController {
    private PlayerInput playerInput;
    private WorldManager worldManager;
    private EnemyManager enemyManager;

    public GameController() {
        this.worldManager = WorldManager.getInstance();
        this.enemyManager = new EnemyManager(worldManager.getCurrentWorld());
        this.playerInput = new PlayerInput(enemyManager);
    }

    public void startGame() {
        List<World> worlds = new ArrayList<>();
        worlds.add(new Jumanji());
        worlds.add(new Caribe());
        worlds.add(new Mordor());
    
        for (World world : worlds) {
            // Set the current world
            worldManager.setCurrentWorld(world);
    
            // Logic to initialize the game
            System.out.println("Starting game in the world " + world.getName());
    
            // Generate enemies for the current world
            enemyManager.spawnEnemies(world,2);
    
            
            while (playerInput.getPlayer().getHP() > 0 && enemyManager.areEnemiesRemaining()) {
                playerInput.actionMenu();
                
                // Jugador muerto = Bucle roto
                if (playerInput.getPlayer().getHP() <= 0) {
                    break;
                }
                
                // No quedan enemigos = Salta al siguiente
                if (!enemyManager.areEnemiesRemaining()) {
                    System.out.println("You've defeated all enemies in the world: " + world.getName());
                   
                    break;
                }
            }
    
            // Check if the player's HP is depleted
            if (playerInput.getPlayer().getHP() <= 0) {
                System.out.println("YOU DIED.");
                break; // End the game if the player loses
            }
            
            // Check if all worlds are completed
            if (world == worlds.get(worlds.size() - 1)) {
                System.out.println("You've completed all the worlds! Congrats!");
            } else {
                System.out.println("You've completed the world: " + world.getName() + "! Prepare for the next!");
            }
        }
    
        // Game logic after completing all worlds or if the game has ended
        System.out.println("END OF GAME.");
    }
}
