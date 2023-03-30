import java.util.ArrayList;

/*
 * A room is a collection of tiles that can hold entities. Part of a map.
 */
public class room {
    
    private ArrayList<ArrayList<tile>> room = new ArrayList<ArrayList<tile>>();
    private int width;
    private int height;
    private String desc;
    private String special = null;

    /*
     * Construct a room of certain width and height in tiles
     */
    public void room(int width, int height){
        this.width = width;
        this.height = height;
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
}
