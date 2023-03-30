/*
 * An obstacle prevents a player from passing through a tile
 */
public class obstacle {
    private String name;

    /*Constructor for an obstacle with a name*/
    public void obstacle(String name){
        this.name = name;
    }

    public String getName(){return name;}
}
