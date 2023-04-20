public class exit {
    
    private int targetx = 0;
    private int targety = 0;
    private room sourceRoom;
    private room targetRoom;
    public exit(room sourceRoom, room targetRoom){
        this.sourceRoom = sourceRoom;
        this.targetRoom = targetRoom;
    }

    public void changeRoom(){
        this.sourceRoom.exitRoom(player.getPlayer().getXcord(), player.getPlayer().getYcord());
        this.targetRoom.enterRoom(this.targetx, this.targety);
    }
}
