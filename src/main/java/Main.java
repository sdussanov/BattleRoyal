public class Main {
    public static void main(String[] args) {
//        Zombie zombie1 = new Zombie("Steve");
//        zombie1.attack();
//        zombie1.growl();
//        zombie1.growl(true);
//        zombie1.growl(false);
//        Zombie zombie2 = new Zombie("Bob");
//        zombie2.attack();
//        zombie2.growl();

        Battle battle = new Battle();
        battle.add(new Zombie("Steve"));
        battle.add(new Zombie("Bob"));
        battle.add(new Zombie("Frank"));
        battle.add(new Vampire("Eva"));
        battle.add(new Vampire("Alice"));

        battle.add(new Zombie("Paul"));
        battle.add(new Vampire("Jane"));

        battle.start();
    }
}
