public class Trader implements Seller {
    private static int potion = 10;
    private final int PRICE = 10;

    @Override
    public void sell(Character character){
        int gold = character.getGold();

        if (gold >= PRICE){
            character.setGold(gold - PRICE);
            ((Human)character).setPotion(((Human)character).getPotion() + 1);
        } else {
            System.out.println("You don't have enough gold!");
        }
    }

}
