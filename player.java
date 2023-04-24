import java.util.LinkedList;

public class player extends character{

    private static player pc;

    private inventory inv;
    private int xcord;
    private int ycord;
    private int baseAttack = 10;
    private int baseDefense = 0;
    private room currentRoom;
    
    public room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public inventory getInv() {
        return inv;
    }    

    public int getBaseDefense() {
        return baseDefense;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getXcord() {
        return xcord;
    }

    public void setXcord(int xcord) {
        this.xcord = xcord;
    }

    public int getYcord() {
        return ycord;
    }

    public void setYcord(int ycord) {
        this.ycord = ycord;
    }

    private player(String name, String desc, int x, int y) {
        super(name);
        this.setHealth(100);    
        this.setAttack(10);
        this.setDefense(0);
        this.setDesc(desc);
        xcord = x;
        ycord = y;
        inv = new inventory();
    }

    /*
     * method used to create player, ensures only a single player exists at a time
     */
    public static player createPlayer(String name, String desc){
        if (!(pc instanceof player)){
            pc = new player(name,desc,0,0);
        }
        return pc;
    }

    public static player getPlayer(){
        return pc;
    }

    public void useItem(int index){
        try{        
            pc.getInv().useItem(index);
        }
        catch (Exception e){
            System.out.println("Invalid Input");
        }
    }

    public void printInventory(){
        pc.getInv().printInventory();
    }
    /*moves the player according to the direction entered:
     * 1 2 3 
     * 4   5
     * 6 7 8
     */
    public void move(int direction){
        int newx = xcord;
        int newy = ycord;
        if (direction >= 1 && direction <= 8){
            if (direction <= 3){
                newy++;
            }
            if (direction > 5){
                newy--;
            }
            if (direction ==1 || direction == 4 || direction ==6){
                newx--;
            }
            if (direction == 3 || direction == 5 || direction == 8){
                newx++;
            }
            
            if(currentRoom.movePlayer(xcord,ycord,newx,newy)){
                this.xcord = newx;
                this.ycord = newy;
            }
            
        }
        else{
            System.out.println("Not a valid move.");
        }
    }

    public void pickUpItems(LinkedList<item> items){
        for (item i:items)
        {
            this.inv.addItem(i);
        }
    }
    public void openChest(chest c){
        System.out.println(this.getName() + " opened a chest!");
        LinkedList<item> droppedItems = c.dropItems();
        pickUpItems(droppedItems);
    }
    public void attackNpcs(){
        Object entity;
        for (int i = xcord - 1; i <= xcord + 1; i++){
            for (int j = ycord - 1; j<= ycord + 1; j++){
                try{
                    entity = currentRoom.getRoom().get(j).get(i).getEntity();
                    if (entity instanceof npc){
                        this.attackCharacter((character) entity);
                        
                    }
                }
                catch (Exception e){
                    continue;
                }
            }
        }
    }

    public String toString(){
        return this.getName() + "'s currently at (" + pc.xcord + ", " + this.ycord + ") with " +this.getHealth() + " health";
    }
}

