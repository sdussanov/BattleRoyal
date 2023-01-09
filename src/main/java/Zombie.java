public class Zombie extends Monster {
    public static String scream = "Raaaauuughhhh! ";

    public Zombie(String name) {
        super(name, 30, 10);

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
        this.growl();
        System.out.printf("%s the Zombie attacked with damage %d another %s %s!\n", this.getName(), this.getForce(), entity.getClass().getName(), entity.getName());
        entity.damage(this.getForce());
    }
}
