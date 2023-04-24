import java.util.LinkedList;
/*
 * A chest is an entity that can be found in rooms
 * which holds items. A passing player can open the chest
 * to retrieve the items inside it and add it to his inventory
 */
public class chest {
    private LinkedList<item> items;

    /*
     * Constructor for a chest that holds items
     * takes in a list of 1-5 items, and throws an exception if the list is empty
     * if the list has more than 5 items it will remove the excess 
     */
    public chest(LinkedList<item> items) throws Exception{
        if (items.size() == 0){
            throw new Exception("Trying to create a chest with no items");
        }
        while (items.size() > 5){
            items.removeLast();
        }
        this.items = items;
    }

    /*returns the list of items that the player will take and empties the chest */
    public LinkedList dropItems(){
        if (this.items != null){
            System.out.println(player.getPlayer().getName() + " has opened a chest and acquired the items inside!");
        }
        LinkedList<item> temp = (LinkedList<item>) this.items.clone();   
        this.items = null;
        return temp;
        
    }

    
}
