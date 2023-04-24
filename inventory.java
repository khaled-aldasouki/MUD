import java.lang.reflect.Array;
import java.util.LinkedList;

public class inventory {
    private int capacity;
    private LinkedList<item> items;
    private bag[] bags;

    public inventory(){
        this.capacity = 6;
        this.items = new LinkedList<item>();
        this.bags = new bag[6]; 
    }

    public void equipBag(bag b){
        for (int i = 0; i<6; i++){
            if (bags[i] == null){
                bags[i] = b;
                capacity += b.getSpace();
                System.out.println("Equipped " + b.getName());
                return;
            }
        }
        for (int j = 0; j <6; j++){
            if (bags[j].getSpace() < b.getSpace()){
                bags[j] = b;
                capacity += (b.getSpace() - bags[j].getSpace());
                System.out.println("Equipped " + b.getName());
                return;
            }
        }
        System.out.println("You cannot equip a bag that will decrease your capacity.");
    }

    public void addItem(item i){
        if (items.size() == capacity){
            System.out.println("Inventory Full!");
        }
        else{
            if (i instanceof bag){
                equipBag((bag) i);
            }
            else{
            items.add(i);
            }
        }
    }

    public void printInventory(){
        System.out.println("Current capacity: " + this.items.size() + "/" + this.capacity);

        System.out.println("Current Inventory: ");
        for (int i = 0; i<items.size();i++){
            System.out.println((i+1) + ". " + items.get(i).getDescription());
        }
    }

    public void useItem(int index){
        if (index > items.size() || index < 0){
            System.out.println("Invalid input!");
        }
        else{
            item i = items.get(index);
            i.use();
            if (i instanceof food){
                items.remove(index);
            }
        }
    }
}
