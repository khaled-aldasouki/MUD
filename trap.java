/*
 * A trap is an entity held in a tile which can 
 * damage a player the first time it is passed through 
 */
public class trap {
    private int attack;
    private boolean disarmed = false;

    /*Constructor for a trap with an attack (damage) value*/
    public trap(int attack){
        this.attack = attack;
    }
    /*Method that disarms a trap, used once a trap has been activated (may be used later to implement a player disarming feature) */
    public void disarm(){disarmed = true;} 

    public void activate(character other){
        other.setHealth(other.getHealth() - attack);
        System.out.println(other.getName() + " activated a trap and took " + this.attack + " damage! " + other.getName() + " is now at " + other.getHealth() + " health points.");
    }
    /*Method used to damage a player that has activated this trap, then disarm it*/
    public void damagePlayer(character player){
        if (this.disarmed == false){
            
            this.disarm();
        }
    }
}
