public class Zombie extends Monster {
    public static String scream = "Raaaauuughhhh! ";

    public Zombie(String name) {
        super(name + " the Zombie", 30, 10);

    }

    @Override
    public void growl() {
        System.out.print(scream);
        super.growl();
    }

    public void growl(boolean isLoud) {
        if (!isLoud) {
            this.growl();
        } else {
            System.out.print(scream.toUpperCase());
            super.growl();
        }
    }

    @Override
    public void attack(Monster monster) {
        this.growl();
        monster.damage(this.getForce());
        System.out.printf("Monster %s attacked with damage %d another monster %s!\n", this.getName(), this.getForce(), monster.getName());
    }
}
