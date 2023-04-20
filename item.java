public abstract class item {
    private String name;
    private String description;
    private int goldValue;

    public item(String name, int goldValue){
        this.name = name;
        this.goldValue = goldValue;
    }
    abstract public void use(player pc);
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getGoldValue() {
        return goldValue;
    }
    public void setGoldValue(int goldValue) {
        this.goldValue = goldValue;
    }
}
