public class exit {
    
    private int targetx;
    private int targety;

    public exit(int targetx, int targety){
        this.targetx = targetx;
        this.targety = targety;
    }

    public void changeRoom(room sourceRoom, room targetRoom){
        sourceRoom.exitRoom(player.getPlayer().getXcord(), player.getPlayer().getYcord());
        targetRoom.enterRoom(this.targetx, this.targety);
    }
}
