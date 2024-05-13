package factory;

import state.*;
import strategy.ActionStrategy;

public abstract class Entity {
	
	// Atributos propios
    private int ATK;
    private int HP;
    public static final int DEFAULT_HP = 70; // común para todos, sus resistencias individuales vienen de su def
    public static final int DEFAULT_LOWHP = 40;
    private double DEF; // porcentaje
    private String name;

    private EntityState currentState;
    private NormalState normalState;
    private PoisonedState poisonedState;
    private InjuredState injuredState;

    public Entity() {
        this.ATK = 0;
        this.DEF = 0;
        this.HP = 0;
        this.name = "";
        this.normalState = new NormalState();
        this.poisonedState = new PoisonedState();
        this.injuredState = new InjuredState();
        this.currentState = normalState;
    }

    public Entity(int ATK, int HP, double DEF, String name){
        this.ATK = ATK;
        this.HP = HP;
        this.DEF = DEF;
        this.name = name;
        this.normalState = new NormalState();
        this.poisonedState = new PoisonedState();
        this.injuredState = new InjuredState();
        this.currentState = normalState;
    }

     private ActionStrategy actionStrategy; // Strategy pattern

    // Strategy pattern integration
    public void setActionStrategy(ActionStrategy actionStrategy) {
        this.actionStrategy = actionStrategy;
    }

    public void executeAction() {
        if (actionStrategy != null) {
            actionStrategy.action(this);
        } else {
            System.out.println("No action strategy set.");
        }
    }
    
    // GETTERS
    public int getATK(){
        return this.ATK;
    }
    public int getHP(){
        return this.HP;
    }
    public double getDEF(){
        return this.DEF;
    }
    public String getName(){
        return this.name;
    }
    public NormalState getNormalState() {
        return normalState;
    }
    public PoisonedState getPoisonedState() {
        return poisonedState;
    }
    public InjuredState getInjuredState(){
        return injuredState;
    }
    public EntityState getCurrentState() {
        return currentState;
    }

    // SETTERS
    public void setATK(int atk) {
        this.ATK = atk;
    }
    public void setHP(int hp) {
        this.HP = hp;
    }
    public void setDEF(double def) {
        this.DEF = def;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNormalState(NormalState normalState) {
        this.normalState = normalState;
    }
    public void setPoisonedState(PoisonedState poisonedState) {
        this.poisonedState = poisonedState;
    }
    public void setInjuredState(InjuredState injuredState){
        this.injuredState = injuredState;
    }
    public void setCurrentState(EntityState currentState) {
        this.currentState = currentState;
    }

    // State pattern integration
    public void applyEffect() {
        if (currentState != null) {
            currentState.applyEffect(this);
        }
    }

    public void updateState() {
        if (currentState != null) {
            currentState.updateState(this);
        }
    }

    // BONUSES
    public void atkBonus(int atkBonus) {
        this.setATK(getATK() + atkBonus);
    }
    public void hpBonus(int hpBonus) {
        this.setHP(getHP() + hpBonus);
    }
    public void defBonus(double defBonus) {
        this.setDEF(getDEF() + defBonus);
    }
    
    
}
