public class factory {
    
    public static item itemFactory(String itemType, String name, int goldValue, int effectValue){
        switch (itemType){
            case "food":
                return new food(name, goldValue, effectValue);
            case "weapon":
                return new weapon(name, goldValue, effectValue);
            case "armor":
                return new armor(name, goldValue, effectValue);
            case "bag":
                return new bag(name, goldValue, effectValue);
            default:
                throw new IllegalArgumentException("No item type " + itemType + ". Can only create food, weapon, armor, and bag.");
                
        }
    }

    
}
