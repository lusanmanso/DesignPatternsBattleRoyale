package facade;

import singleton.*;
import extra.*;

public class Level {

    private World world;
    private WorldManager worldManager;
    private EnemyManager enemyManager;
    private PlayerManager playerManager;

    public Level(World world, WorldManager worldManager, EnemyManager enemyManager, PlayerManager playerManager) {
        this.world = world;
        this.worldManager = worldManager;
        this.enemyManager = enemyManager;
        this.playerManager = playerManager;
    }

    public void start() {

        worldManager.setCurrentWorld(world);

        System.out.println("Starting game in the world " + world.getName());

        enemyManager.spawnEnemies();

        while (playerManager.getPlayer().getHP() > 0 && enemyManager.areEnemiesRemaining()) {
            playerManager.actionMenu();

            // Player dead = Break loop
            if (playerManager.getPlayer().getHP() <= 0) {
                break;
            }

            // No enemies remaining = Jump to the next
            if (!enemyManager.areEnemiesRemaining()) {
                System.out.println("You've defeated all enemies in the world: " + world.getName());
                break;
            }
        }

        // Check if the player's HP is depleted
        if (playerManager.getPlayer().getHP() <= 0) {
            System.out.println("YOU DIED.");
            return; // End the game if the player loses
        }

        System.out.println("You've completed the world: " + world.getName() + "! Prepare for the next!");
    }
}