import java.util.Arrays;
import java.util.Objects;

public class Human extends Character {
    private int potion;
    Backpack backpack;


    public Human(String name, int health, int attack, int defence, int mana, int strength, int agility, int intelligence, int exp, int gold, int potion) {
        super(name, health, attack, defence, mana, strength, agility, intelligence, exp, gold);
        this.potion = potion;
        this.backpack = new Backpack();
    }

    public int getPotion() {
        return potion;
    }

    public void setPotion(int potion) {
        this.potion = potion;
    }

    @Override
    public int attack(Character enemy) {
        int damage = Math.max(0, this.getAttack() - enemy.getDefense());
        enemy.setHealth(enemy.getHealth() - damage);
        System.out.println(this.getName() + " attacks " + enemy.getName() + " for " + damage + " damage!");
        return damage;
    }

    @Override
    public String toString() {
        return String.format("%s Health: %d", this.getName(), this.getHealth());
    }

    class Backpack {
        String[] items = new String[6];
        private int counter = 0;

        public void put(String item) {
            if (counter < items.length) {
                items[counter++] = item;
            } else {
                System.out.println("No more items!");
            }
        }

        @Override
        public String toString() {
            if (counter == 0) {
                return "The backpack is empty!";
            }
            return Arrays.toString(Arrays.stream(items).filter(Objects::nonNull).toArray(String[]::new)).replace("[", "").replace("]", "") +
                    " in the backpack!";
        }
    }
}
