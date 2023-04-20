 

public class app {
    public static void main(String args[]){
        
        player pc = new player("khaled", "SE", 0,0);
        weapon w = new weapon("axe",10,5);
        armor a = new armor("helmet", 5, 10);
        bag b = new bag("large bag",5, 10);

        pc.getInv().equipBag(b);
        pc.getInv().pickUpItem(w);
        pc.getInv().pickUpItem(a);
        pc.getInv().printInventory();
        pc.getInv().useItem(0);
        pc.getInv().useItem(1);
        


}
}
