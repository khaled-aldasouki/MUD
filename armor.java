public class armor extends item{
    private int defenseValue;

    public armor(String name, int goldValue, int defenseValue) {
        super(name, goldValue);
        this.defenseValue = defenseValue;
        this.setDescription( "A " + this.getName() + " that will increase the weilders defense by " + this.defenseValue 
                            + ". Worth " + this.getGoldValue() + " gold.");
    }

    @Override
    public void use() {
        player.getPlayer().setDefense(player.getPlayer().getBaseDefense() + this.defenseValue);
        System.out.println(player.getPlayer().getName() + " equipped " + this.getName()
                            + " and now has " + player.getPlayer().getDefense() + " defense points.");
    }
    
}

