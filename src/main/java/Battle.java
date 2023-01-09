import java.util.Random;

public class Battle {
    private final static int MAX = 5;
    private final Entity[] arrEntity;
    private int counter = 0;

    public Battle() {
        arrEntity = new Monster[MAX];
    }

    public void add(Entity entity) {
        if (counter < MAX) {
            arrEntity[counter++] = entity;
        } else {
            System.out.println("No more monsters!");
        }
    }

    public void start() {
        run();
    }

    public void run() {
        Random random = new Random();
        int destroyed = 0;
        Entity fighter = null;
        while (destroyed != counter - 1) {
            fighter = arrEntity[random.nextInt(counter)];
            Entity victim = arrEntity[random.nextInt(counter)];

            while (victim == null || fighter == victim || !(fighter instanceof Fightable) || victim.isDestroyed() || fighter.isDestroyed()) {
                victim = arrEntity[random.nextInt(counter)];
                fighter = arrEntity[random.nextInt(counter)];
            }
            ((Fightable) fighter).attack(victim);
            if (victim.isDestroyed()) {
                victim = null;
                destroyed++;
            }
        }

        System.out.println("The Great Battle is finished and winner is " + fighter);

    }
}