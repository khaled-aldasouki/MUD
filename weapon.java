public class weapon extends item{
    private int attackValue;

    public weapon(String name, int goldValue, int attackValue) {
        super(name, goldValue);
        this.attackValue = attackValue;
        this.setDescription( "A " + this.getName() + " that will increase the weilders attack by " + this.attackValue 
                            + ". Worth " + this.getGoldValue() + " gold.");
    }

    @Override
    public void use(player pc) {
        pc.setAttack(pc.getBaseAttack() + this.attackValue);
        System.out.println("Player equipped " + this.getName()
                            + " and now has " + pc.getAttack() + " attack points.");
    }
    
}
