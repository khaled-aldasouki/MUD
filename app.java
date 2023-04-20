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
        room secondRoom = new room(10, 10);

        exit e = new exit(firstRoom,secondRoom);
        firstRoom.addEntity(3, 0, e);
        firstRoom.enterRoom(0, 0);
        pc.move(firstRoom, 2);
        pc.move(firstRoom, 2);
        pc.move(firstRoom, 2);

        System.out.println(pc.getXcord() + "," + pc.getYcord());



        

}
}
