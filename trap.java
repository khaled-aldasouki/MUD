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

    public void activate(){
        if (this.disarmed == false){
            player pc = player.getPlayer();
            pc.setHealth(pc.getHealth() - attack);
            System.out.println(pc.getName() + " activated a trap and took " + this.attack + " damage! " + pc.getName() + " is now at " + pc.getHealth() + " health points.");
            this.disarm();
        }
    }
    
}
