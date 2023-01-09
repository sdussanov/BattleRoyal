public class Vampire extends Monster {
    public static String scream = "Sssssssssssssss! ";

    public Vampire(String name) {
        super(name,20, 15);

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
    public void attack(Entity entity) {
        this.growl(true);
        System.out.printf("%s the Vampire attacked with damage %d another %s %s!\n", this.getName(), this.getForce(), entity.getClass().getName(), entity.getName());
        System.out.println("And hid in the dark...");
        entity.damage(this.getForce());
    }
}
