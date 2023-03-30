


/*
 * A tile is a 3x3 foot sized square representing a section of a room in a map.
 * a tile can be empty or can hold a trap which is triggered by a passing player, a chest which
 * holds 1-5 items, a character (either an enemy npc or a passing player), an 
 * obstacle preventing the player from passing the tile, or finally an exit which leads to another room
 */
public class tile{
    private boolean passable;
    private Object entity;

    /*Empty Tile constructor */
    public void tile(){
        passable = true;
        this.passable = passableCheck();
    }
    /*
     *Constructor for a tile holding an entity (chest,trap,exit,character,obstacle)
     *automatically determines if the tile is passable or not based on the held entity
     */
    public void tile(Object entity){
        this.entity = entity;
        this.passable = passableCheck();
    }

    public Object getEntity() {return entity;}

    /*Sets the entity and does a check to determine whether the tile is passable or not */
    public void setEntity(Object entity) {
        this.entity = entity;
        this.passable = passableCheck();
    }

    /* 
     *Method is used to determine if the player can move into the tile
     *@return true if the tile is passable, false otherwise 
     */
    public boolean isPassable(){return this.passable;}


    /*
     * Method to check whether a tile is passable or not based on the entity the tile is holding
     * @return true if the tile is passable, false if not.
     */
    private boolean passableCheck(){
        if (this.entity instanceof obstacle || this.entity instanceof character ){return false;}
        else{return true;}
    }
}