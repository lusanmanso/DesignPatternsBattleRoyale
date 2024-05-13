package extra;

import java.util.ArrayList;
import java.util.List;

import singleton.*;
import state.*;

import strategy.*;
import factory.*;
import java.util.ArrayList; // Import the ArrayList class

public class EnemyManager {
    private World currentWorld;
    private Enemy currentEnemy;
    private List<Enemy> remainingEnemies;
    private EnemyStrategy enemyStrategy;
    private EntityState entityState;

    public EnemyManager(World currentWorld) {
        this.currentWorld = currentWorld;
        this.remainingEnemies = new ArrayList<>();
    }

    public List<Enemy> spawnEnemies(World currentWorld, int nEnemies) {
       //  List<Enemy> newEnemies = new ArrayList<>();
        if (currentWorld == null) {
            System.out.println("A valid world has not been provided for generating enemies.");
            return null;
        }
        
        // Obtener la fábrica de enemigos correspondiente al mundo actual
        EnemyAbstractFactory enemyAbstractFactory = currentWorld.getEnemyFactory();

        // Lógica 
        if (enemyAbstractFactory != null) {
            for (int i = 0; i < nEnemies; i++) {
                // Generar un enemigo de forma aleatoria
                Enemy newEnemy = createRandomEnemy(enemyAbstractFactory);
                newEnemy.setHP(newEnemy.getMaxHP());
                remainingEnemies.add(newEnemy); // Agregar el nuevo enemigo a la lista de enemigos restantes
             
                
                currentEnemy = remainingEnemies.get(0); // Set the first spawned enemy as the current enemy if there wasn't one before
                
            }
            
            // Generar un enemigo de forma aleatoria
            // Manejar el caso en el que no se haya obtenido la fábrica de enemigos

            
        }else{
            

            System.out.println("The enemy factory for the current world could not be found.");

            // Podrías lanzar una excepción o tomar otra acción apropiada
            return null;
        }

        return remainingEnemies;
    }

    private Enemy createRandomEnemy(EnemyAbstractFactory enemyFactory) {
        double randomNumber = Math.random();
        if (randomNumber < 0.33) {
            return enemyFactory.createWitch();
        } else if (randomNumber < 0.66) {
            return enemyFactory.createDaemon();
        } else {
            return enemyFactory.createTroll();
        }
    }

    public void setCurrentEnemy(Enemy enemy) {
        this.currentEnemy = enemy;
    }

    public Enemy getCurrentEnemy() {
        return currentEnemy;
    }
    
    public void moveToNextEnemy() {
    
        if (!remainingEnemies.isEmpty()) {
            // Remove the first enemy from the list
            remainingEnemies.remove(0); // Remove element at index 0
            if (remainingEnemies.isEmpty()) {
               moveToWorld(); // If there are no more enemies in the current world, spawn new ones
            } else {
                currentEnemy = remainingEnemies.get(0); // Set the next enemy as the current enemy
                currentEnemy.setHP(currentEnemy.getMaxHP());
                
            }
        } else {
            moveToWorld();
        }
    }

    private void moveToWorld() {
        List<World> worlds = WorldManager.getInstance().getWorlds();
        int currentWorldIndex = worlds.indexOf(currentWorld);
        
        if (currentWorldIndex < worlds.size() - 1) {
            setCurrentWorld(worlds.get(currentWorldIndex + 1));
            spawnEnemies(currentWorld, 2); // Generar enemigos para el nuevo mundo
            
        } else {
            setCurrentWorld(null); // No hay más mundos, establecer el mundo actual como null
        }
    }

    
    public boolean areEnemiesRemaining() {

        return !remainingEnemies.isEmpty();
    }
 
    // Otros métodos de la clase...

    // Getter y setter para el campo currentWorld
    public World getCurrentWorld() {
        return currentWorld;
    }

    public void setCurrentWorld(World currentWorld) {
        this.currentWorld = currentWorld;
    }

        //State
    public void setEntityState(EntityState entityState) {
        this.entityState = entityState;
    }

    public void enemyAttack(Enemy enemy, Player player) {
            double defense = player.getDEF();
     
            int pain = calculateDamage(enemy, defense); // Calculate damage based on enemy's ATK and player's DEF
            player.setHP(player.getHP() - pain); // Apply damage to player's HP directly
            System.out.println(enemy.getName() + " attacks you for " + pain + " damage! Now you have "+player.getHP()+" HP!");
        
    }

    private int calculateDamage(Enemy enemy, double defense) {
        // Implement logic to calculate damage based on enemy's ATK and player's DEF
         // Assuming the player has a defense attribute
         int pain = (int) (enemy.getATK()  * (1 - defense/ 100.0));
       // Ensure damage is non-negative
        return pain;
    }

    public void performEnemyAction(Enemy enemy, Player player) {
        // Perform enemy actions, such as attacking the player
       enemyAttack(enemy, player);
    }

    public void performEnemyAction(Entity target) {
        if (currentEnemy != null && enemyStrategy != null) {
            // Apply state effect based on enemy attack

            // int damage = calculateDamage();
           // entityState.applyEffect(target, damage);
            
            enemyStrategy.action(target); // Acción atada a al estrategia            
            entityState.updateState(target); // Actualiza su estado
        } else {
            System.out.println("No current enemy or enemy strategy set.");
        }
    }

}
