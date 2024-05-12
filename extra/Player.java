package extra;

import strategy.*;
import factory.*;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Player extends Entity {

    private static Scanner scanner = new Scanner(System.in);
    private ActionStrategy actionStrategy;
    private EnemyAbstractFactory currentWorld; // Agregar una propiedad para almacenar el mundo actual

    public Player() {
        super();
        createPlayer();
    }

    public void createPlayer() {
        Narrator narrator = new Narrator();

        narrator.addText("What is your name, traveller? ");
        narrator.startNarration();
        String nombre = scanner.nextLine();
        super.setName(nombre);

        System.out.println(super.getName());

        narrator.addText("Hello, " + nombre + ". You have 30 points to assign to your attack, defense and life.");
        narrator.addText("Choose carefully.");
        narrator.startNarration();

        
        int pATK = askForPoints("Choose your attack points: ");
        super.setATK(pATK);

        int pHP = askForPoints("Choose your life points: ");
       
            try {
                super.setHP(pHP);

                if(super.getHP()<=0){
                    throw new Exception("You can't start dead! Try again!");
                }
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                createPlayer();
            }
       
      

        double pDEF = askForPoints("Choose your defense points: ");
        super.setDEF(pDEF);



        if((super.getATK() + super.getHP()+ super.getDEF())>30){
            System.out.println("You went out of line pal...");
           createPlayer();
         }
        


        narrator.addText(nombre + " has " + super.getATK() + " ATK, " + super.getHP() + " HP y " + super.getDEF() + " DEF.");
        narrator.startNarration();
    }

    // Los puntos no tienen que ser negativos
    private int askForPoints(String message) {
        int points = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                Narrator narrator = new Narrator();
                narrator.addText(message);
                narrator.startNarration();
                points = scanner.nextInt();
                
                if (points < 0) {
                    throw new InputMismatchException("The points cannot be negative.");
                } if ( points > 30) {
                    throw new InputMismatchException("You cannot assign more than 30 points in one place.");
                } 
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Please introduce a valid number.");
                scanner.nextLine(); // Descarta la entrada incorrecta
            }
        }
        return points;
    }

    public void setActionStrategy(ActionStrategy actionStrategy) {
        this.actionStrategy = actionStrategy;
    }

    public ActionStrategy getActionStrategy() {
        return actionStrategy;
    }

    

    public void executeAction(Entity target) {

        if (actionStrategy != null) {
            actionStrategy.action(target);
        } else {
            System.out.println("There has been no attack strategy assigned.");
        }
    }



}