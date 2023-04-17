public class player extends character{

    private Inventory inv = new Inventory();
    private Weapon weapon;
    private Armor armor;
    private int xcord;
    private int ycord;

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
}
