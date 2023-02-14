import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader br;
    private static Character player = null;
    private static Battle Battle = null;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        Battle = new Battle();
        System.out.println("Type your name:");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void command(String string) throws IOException {

        if (player == null) {
            player = new Human(string, 1000, 55, 10, 100, 100, 30, 50, 0, 0,0);
            System.out.println(String.format("Greet our hero %s! He will fight monsters!", player.getName()));
            printNavigation();
        }

        switch (string) {
            case "1": {
                new Trader().sell(player);
            }
            break;
            case "2": {
                drinkPotion();
            }
            break;
            case "3": {
                commitFight();
            }
            break;
            case "4":
                System.exit(1);
                break;
            case "yes":
                command("2");
                break;
            case "no": {
                printNavigation();
                command(br.readLine());
            }
        }
        command(br.readLine());
    }

    private static void drinkPotion() {
        if (((Human)player).getPotion() > 0) {
            player.setHealth(player.getHealth() + 100);
            ((Human)player).setPotion(((Human)player).getPotion() - 1);
            System.out.println(String.format("Healed you 100 health points, now you have %d health points and you've got %d potions...", player.getHealth(), ((Human)player).getPotion()));
        } else {
            System.out.println("You don't have potion in your backpack...");
        }
    }


    private static void commitFight() {
        Battle.fight(player, createMonster(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s won! Now you have %d exp and %d gold, also you've got %d health points.", player.getName(), player.getExp(), player.getGold(), player.getHealth()));
                System.out.println("Do you want ot continue or return to the city? (yes/no)");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {

            }
        });
    }

    private static void printNavigation() {
        System.out.println("Where do you want to go?");
        System.out.println("1. Buy potion");
        System.out.println("2. Drink potion");
        System.out.println("3. Go to the dark forest");
        System.out.println("4. Exit");
    }

    private static Character createMonster() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0) return new Zombie("Nemesis", 800, 50, 15, 35, 15,20,100);
        else return new Vampire("Dracula", 700, 60, 10, 200, 20,50,50,40,150);
    }

    interface FightCallback {
        void fightWin();
        void fightLost();
    }
}