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

    public void run() {
        for (Monster monster : arrMonsters) {
            if (monster != null) {
                monster.attack();
            }
        }
    }


}
