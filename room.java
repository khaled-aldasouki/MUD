import java.util.ArrayList;

/*
 * A room is a collection of tiles that can hold entities. Part of a map.
 */
public class room {
    
    private ArrayList<ArrayList<tile>> room = new ArrayList<ArrayList<tile>>();
    public ArrayList<ArrayList<tile>> getRoom() {
        return room;
    }

    private int width;
    private int height;
    private String desc;
    private String special = null;

    /*
     * Construct a room of certain width and height in tiles
     */
    public room(int width, int height){
        this.width = width;
        this.height = height;
        for (int i =0;i < height;i++){
            room.add(new ArrayList<tile>());
        }

        for (ArrayList<tile> list : room){
            list.add(new tile());
        }
    }


    public room(int width, int height,String special){
        this.width = width;
        this.height = height;
        this.special = special;
        for (int i =0;i < height;i++){
            room.add(new ArrayList<tile>());
        }

        for (ArrayList<tile> list : room){
            list.add(new tile());
        }
    }

    /*Set a room to be the start or goal room */
    public void setSpecial(String type) {
        if (type.equals("goal") || type.equals("start")){
            this.special=type;
        }
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }

    /*
     * Method used to add an entity (such as a character or chest) into a map at a certain location
     */
    public void addEntity(int height, int width, Object entity){
        room.get(height).get(width).setEntity(entity);
    }

    public void movePlayer(int xcord, int ycord, int newx, int newy) {
        try{
            tile newLocation = this.room.get(newy).get(newx);
            tile oldLocation = this.room.get(ycord).get(xcord);
            if (newLocation.isPassable()){
                if (newLocation.getEntity() instanceof chest){
                    player.getPlayer().openChest(((chest)newLocation.getEntity()));
                }
                if (newLocation.getEntity() instanceof exit){
                    ((exit) newLocation.getEntity()).changeRoom();
                }
                newLocation.setEntity(player.getPlayer());
                oldLocation.setEntity(null);
            }
            else{
                newLocation = (tile) newLocation;
                System.out.println("An " + newLocation.getEntity() + " is blocking the way.");
            }
        }
        catch (Exception e){
            System.out.println("Cannot move in that direction." + e);
        }
    }

    public void exitRoom(int xcord, int ycord){
            tile oldLocation = this.room.get(ycord).get(xcord);
            oldLocation.setEntity(null);  
    }

    public void enterRoom(int xcord, int ycord){
        player.getPlayer().setXcord(xcord);
        player.getPlayer().setYcord(ycord);
        if (this.special == null){
            System.out.println(player.getPlayer().getName() + " has entered a new room!");
        }
        else if (this.special.equals("start")){
            System.out.println("Welcome to the dungeon!");
        }
        else if (this.special.equals("goal")){
            System.out.println(player.getPlayer().getName() + " has entered the final room!");
        }
        
    }
}
