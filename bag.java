public class bag extends item{

    private int space;

    public bag(String name, int goldValue, int space) {
        super(name, goldValue);
        this.space = space;
        this.setDescription("A " + this.getName() + " that can hold " + this.space + ". Worth " + this.getGoldValue() + "gold.");
    }

    public int getSpace(){
        return this.space;
    }
    
    @Override
    public void use() {
        player.getPlayer().getInv().equipBag(this);
        
    }
    
}
