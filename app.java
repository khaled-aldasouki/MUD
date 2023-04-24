import java.util.LinkedList;
import java.util.Scanner;

public class app {
    public static void main(String args[]) throws Exception{

        //creating the scanner to take input
        Scanner scanner = new Scanner(System.in);
        
        //create player
        System.out.println("Enter your characeters name: ");
        String playerName = scanner.nextLine();
        System.out.println("Enter your characeters description: ");
        String playerDesc = scanner.nextLine();
        player pc = player.createPlayer(playerName, playerDesc);


        //create the rooms
        room firstRoom = new room(10, 10,"start");
        room secondRoom = new room(10, 5);
        room thirdRoom = new room (5,5);
        room finalRoom = new room(5,5,"goal");

        //add exits 
        exit exit1 = new exit(firstRoom,secondRoom);
        firstRoom.addEntity(9, 0, exit1);
        exit exit2 = new exit(secondRoom,thirdRoom);
        secondRoom.addEntity(3, 9, exit2);
        exit exit3 = new exit(thirdRoom,finalRoom);
        thirdRoom.addEntity(4, 4, exit3);

        //create and add entities

        //creating a chest

        item chestItem1 = factory.itemFactory("weapon","axe",5,10);
        item chestItem2 = factory.itemFactory("armor","helmet", 5, 10);
        item chestItem3 = factory.itemFactory("bag", "large bag",5, 10);
        item chestItem4 = factory.itemFactory("food","apple",5,10);

        LinkedList<item> chestlist = new LinkedList<item>();
        chestlist.add(chestItem1);
        chestlist.add(chestItem2);
        chestlist.add(chestItem3);
        chestlist.add(chestItem4);
        chest chest1 = new chest(chestlist);

        //creating some obstacles 
        obstacle table = new obstacle("table");
        obstacle statue = new obstacle("statue");

        firstRoom.addEntity(7, 4, new trap(10));
        firstRoom.addEntity(5, 4, chest1);
        firstRoom.addEntity(3, 2, table);
        firstRoom.addEntity(7, 3, statue);

        secondRoom.addEntity(2, 4, table);
        secondRoom.addEntity(3, 1, statue);

        thirdRoom.addEntity(2, 4, table);
        thirdRoom.addEntity(3, 1, statue);

        //create and add enemies
        npc enemy1 = new npc("Goblin");
        npc enemy2 = new npc("Skeleton");
        npc enemy3 = new npc("Mimic Chest");
        npc enemy4 = new npc("Minotaur");

        firstRoom.addEntity(6, 1, enemy1);
        firstRoom.addEntity(7, 6, enemy2);
        secondRoom.addEntity(4, 3, enemy3);
        thirdRoom.addEntity(2, 2, enemy4);

        

        firstRoom.setDesc("A large hall with a " + enemy1.getDesc() + " and a " + enemy2.getDesc() + ". The room has a table, a chest, a statue, and an exit on the north wall.");
        secondRoom.setDesc("A library with a " + enemy3.getDesc() + ". The room has a table, a statue, and an exit on the east wall.");
        thirdRoom.setDesc("A prision with a " + enemy4.getDesc() + ". The room has a table, a statue, and an exit in the north east corner.");

        firstRoom.enterRoom(0, 0);

        String input;
        String input2;
        int turns = 3; //every 3 turns, the enemies attack
        while (true){
            System.out.println(pc);
            System.out.println("Turns until enemies attack: " + turns);
            System.out.println("Please enter an option or q to quit:\n1.Move\n2.Attack nearby enemy\n3.Inventory\n4.Use an item");
            input = scanner.nextLine();
            switch (input){
                case "1":
                    System.out.println("Enter the number of the direction you want to move: \n1 2 3\n4   5\n6 7 8");
                    input2 = scanner.nextLine();
                    try{                    
                        pc.move( Integer.parseInt(input2));
                        turns--;
                        
                    }
                    catch (Exception e){System.out.println("Invalid Input");}
                    break;
                case "2":
                    pc.attackNpcs();
                    turns--;
                    break;
                case "3":
                    pc.getInv().printInventory();
                    break;
                case "4":
                    pc.getInv().printInventory();
                    System.out.println("Enter the number of the item you want to use: ");
                    input2 = scanner.nextLine();
                    try{pc.useItem(  Integer.parseInt(input2) - 1);}
                    catch (Exception e){System.out.println("Invalid Input");}

                    break;
                case "q":
                    System.exit(0);
                default: 
                    System.out.println("Invalid option");
                    break;
                               
            }
            if (turns == 0){
                System.out.println("Enemies are attacking!");
                enemy1.attackPlayers(firstRoom,1,6);
                enemy2.attackPlayers(firstRoom,6,7);
                enemy3.attackPlayers(secondRoom,3,4);
                enemy4.attackPlayers(thirdRoom,2,2);
                turns=3;
            }
            System.out.println("--------------------------------------------------------------------------------");

        }
  

}
}
