
public abstract class character {
    private String name;
    private String desc;
    private int health;
    private int attack;
    private int defense;

    public character(String name){
        this.name = name;

    }


    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    /*
     * Attack another character and deal your attack - his defense as damage,
     * minimum damage dealt is 1.
     */
    public void attackCharacter(character other){
        if (other.getHealth() > 0){
            int damage = this.attack - other.getDefense();
            if (damage <= 0){damage = 1;}
            other.setHealth(other.getHealth() - damage);
            if (other.getHealth() >0){
                System.out.println(this.name + " attacked " + other.getName() + " and dealt " + damage + " damage! " +other.getName() + " is now at " + other.getHealth() + " health points.");
            } else {
                System.out.println(this.name + " had defeated a " + other.getName() + "!");

            }
    }
    }

    public String toString(){
        return this.name;
    }
}
