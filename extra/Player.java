package extra;

import strategy.*;
import factory.*;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Player extends Entity {

    private static Scanner scanner = new Scanner(System.in);

    public static int maxTotal = 150;
    public static int maxDEF = 70;

    private ActionStrategy actionStrategy;

    public Player() {
        super();
        createPlayer();
    }

    public void createPlayer() {
        Narrator narrator = new Narrator();

        int pATK = 0;
        int pHP = 0;
        int pDEF = 0;

        narrator.addText("What is your name, traveller? ");
        narrator.startNarration();
        String nombre = scanner.nextLine();
        super.setName(nombre);

        while(!validInput(pATK, pHP, pDEF)){
            narrator.addText("Hello, " + nombre + ". You have " + maxTotal + " points to distribute to your attack, life and defense. Your defense will be a percentage out of 100, so that the damage done to you is a percentage of your enemy's attack. The only limit is in defense, which will be at most " + maxDEF + ".");
            narrator.addText("Choose carefully, or you will be asked again.");
            narrator.startNarration();
            narrator.startNarration();
            
            pATK = askForPoints("Choose your attack points: ");
            narrator.addText("You have " + (maxTotal-pATK) + " points left to distribute.");
            narrator.startNarration();
            pHP = askForPoints("Choose your life points: ");
            narrator.addText("You have " + (maxTotal-pATK-pHP) + " points left to distribute.");
            narrator.startNarration();
            pDEF = askForPoints("Choose your defense points: ");
        }

        super.setATK(pATK);
        super.setHP(pHP);
        super.setDEF(pDEF);

        narrator.addText(nombre + " has " + super.getATK() + " ATK, " + super.getHP() + " HP and " + super.getDEF() + " DEF.");
        narrator.startNarration();
    }

    private boolean validInput(int pATK, int pHP, int pDEF){
        if(pATK <=0 || pATK > maxTotal) return false;
        if(pHP <=0 || pHP > maxTotal) return false;
        if(pDEF <0 || pDEF > maxDEF) return false;
        if(pATK + pDEF + pHP > maxTotal) return false;

        return true;
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
                
                if (points <= 0) {
                    throw new InputMismatchException("The points cannot be negative.");
                } if ( points > Player.maxTotal) {
                    throw new InputMismatchException("You cannot assign more than " + maxTotal + " points in one place.");
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