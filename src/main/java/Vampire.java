public class Vampire extends Character {
    public static String scream = "Sssssssssssssss!";

    public Vampire(String name, int health, int attack, int defence, int mana, int strength, int agility, int intelligence, int exp, int gold) {
        super(name, health, attack, defence, mana, strength, agility, intelligence, exp, gold);
    }

    public void growl() {
        System.out.print(scream);
    }

    public void growl(boolean isLoud) {
        if (!isLoud) {
            this.growl();
        } else {
            System.out.print(scream.toUpperCase());
        }
    }

    @Override
    public int attack(Character enemy) {
        this.growl();
        int damage = Math.max(0, this.getAttack() - enemy.getDefense());
        enemy.setHealth(enemy.getHealth() - damage);
        System.out.println(this.getName() + " attacks " + enemy.getName() + " for " + damage + " damage!");
        return damage;
    }
}
