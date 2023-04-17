import java.util.Random;

/*
 * NPC's are a type of character the the player may encounter while playing,
 * and they can both attack the player and be attacked by him. NPC's have
 * stats that are generated randomly within limits and they may drop gold
 * or items when defeated by the player.
 */
public class npc extends character{
    private Random rand = new Random();

    public npc(String name) {
        super(name);
        this.setHealth(rand.nextInt(100) + 50);    
        this.setAttack(rand.nextInt(10) + 5);
        this.setDefense(rand.nextInt(10));
    }


    /*
     * Method that searches all adjacent tiles and attacks the player if found
     */
    public void attackPlayers(room r, int xcord, int ycord){
        Object entity;
        for (int i = xcord -1; i<= xcord+1; i++){
            for (int j = ycord - 1;j<= ycord+1; j++){
                try{
                    entity = r.getRoom().get(ycord).get(xcord).getEntity();
                    if ( entity instanceof player){
                        attackCharacter((character) entity);
                        break;
                    }
                }
                catch (Exception e){
                    continue;
                }
            }
        }
    }

    
    
}
