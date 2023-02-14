public class Zombie extends Character {
    public static String scream = "Raaaauuughhhh!";

    public Zombie(String name, int health, int attack, int defence, int strength, int agility, int exp, int gold) {
        super(name, health, attack, defence, 0, strength, agility, 0, exp, gold);
    }

    public void growl() {
        System.out.println(scream);
    }

    public void growl(boolean isLoud) {
        if (!isLoud) {
            this.growl();
        } else {
            System.out.println(scream.toUpperCase());
        }
    }

    @Override
    public int attack(Character enemy) {
        this.growl(true);
        int damage = Math.max(0, this.getAttack() - enemy.getDefense());
        enemy.setHealth(enemy.getHealth() - damage);
        System.out.println(this.getName() + " attacks " + enemy.getName() + " for " + damage + " damage!");
        return damage;
    }
}
