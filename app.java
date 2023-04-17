 

public class app {
    public static void main(String args[]){
        character player = new character("player");
        character npc = new character ("npc");
        player.attackCharacter(npc);
        npc.attackCharacter(player);
        trap tra = new trap(5);
        tra.activate(player);
}
}
