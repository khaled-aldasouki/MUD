import java.util.LinkedList;

public class player extends character{

    private inventory inv;
    

    private weapon weapon;
    private armor armor;
    private int xcord;
    private int ycord;
    private int baseAttack = 10;
    private int baseDefense = 0;

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

    public player(String name, String desc, int x, int y) {
        super(name);
        this.setHealth(100);    
        this.setAttack(10);
        this.setDefense(0);
        this.setDesc(desc);
        xcord = x;
        ycord = y;
        inv = new inventory(this);
    }

    /*moves the player according to the direction entered:
     * 1 2 3 
     * 4   5
     * 6 7 8
     */
    public void move(room r, int direction){
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
            r.movePlayer(xcord,ycord,newx,newy);
        }
        else{
            System.out.println("Not a valid move.");
        }
    }

    public void openChest(chest c){
        LinkedList<item> droppedItems = c.dropItems();
        for (item i:droppedItems)
        {
            this.inv.pickUpItem(i);
        }
    }
}
