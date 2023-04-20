import java.util.LinkedList;

public class app {
    public static void main(String args[]) throws Exception{
        
        player pc = player.createPlayer("khaled", "SE");
        npc enemy = new npc("goblin");

        item w = factory.itemFactory("weapon","axe",5,10);
        item a = factory.itemFactory("armor","helmet", 5, 10);
        item b = factory.itemFactory("bag", "large bag",5, 10);
        item f = factory.itemFactory("food","apple",5,10);

       
        LinkedList<item> chestlist = new LinkedList<item>();
        chestlist.add(w);
        chestlist.add(b);
        chestlist.add(a);
        chestlist.add(f);

        chest c = new chest(chestlist);

        pc.printInventory();
        

        obstacle o = new obstacle("table");


        room firstRoom = new room(10, 10,"start");
        firstRoom.enterRoom(0, 0);
        firstRoom.addEntity(1, 0, o);
        pc.move(firstRoom, 2);
        pc.printInventory();

        

}
}
