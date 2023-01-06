public class Vampire extends Monster {
    public static String scream = "Sssssssssssssss! ";

    public Vampire(String name) {
        super(name + " the Vampire", 7);

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
    public void attack() {
        this.growl(true);
        super.attack();
        System.out.println("And hid in the dark...");
    }
}
