import java.util.Random;

public class Battle {
    private final static int MAX = 5;

    private final Monster[] arrMonsters;
    private int counter = 0;

    public Battle() {
        arrMonsters = new Monster[MAX];
    }

    public void add(Monster monster) {
        if (counter < MAX) {
            arrMonsters[counter++] = monster;
        } else {
            System.out.println("No more monsters!");
        }
    }

    public void start() {
        run();
    }

    public void run(){
        Random random = new Random();
        int destroyed = 0;
        Monster fighter = null;
        while (destroyed != counter - 1){
            fighter = arrMonsters[random.nextInt(counter)];
            Monster victim = arrMonsters[random.nextInt(counter)];
            //find non destroyed Fighter and his victim
            while (fighter == null || victim == null || fighter == victim || victim.isDestroyed() || fighter.isDestroyed()) {
                victim = arrMonsters[random.nextInt(counter)];
                fighter = arrMonsters[random.nextInt(counter)];
            }
            fighter.attack(victim);
            if (victim.isDestroyed()){
                victim = null;
                destroyed++;
            }
        }

        System.out.println("The Great Battle is finished and winner is " + fighter);

    }
}