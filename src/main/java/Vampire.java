public class Vampire extends Monster {
    public static String scream = "Sssssssssssssss! ";

    public Vampire(String name) {
        super(name + " the Vampire",20, 15);

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
        this.growl(true);
        monster.damage(this.getForce());
        System.out.printf("Monster %s attacked with damage %d another monster %s!\n", this.getName(), this.getForce(), monster.getName());
        System.out.println("And hid in the dark...");
    }
}
