public class food extends item {

    private int healValue;

    public food(String name,int goldValue,int healValue){
        super(name,goldValue);
        this.healValue = healValue;
        this.setDescription("An " + this.getName() + " that can be consumed to heal "
                            + this.healValue + " health points. Worth " +
                            this.getGoldValue() + " gold.");
    }
    @Override
    public void use() {
        player.getPlayer().setHealth(player.getPlayer().getHealth() + healValue);
        System.out.println("Consumed " + this.getName() + " and healed " + this.healValue + 
                            ". " + player.getPlayer().getName() + "'s health is now " + player.getPlayer().getHealth());
    }
    
}
