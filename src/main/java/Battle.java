public class Battle {

    public void fight(Character human, Character monster, Main.FightCallback fightCallback) {
        Runnable runnable = () -> {
            int turn = 1;
            boolean isFightEnded = false;

            while (!isFightEnded) {
                System.out.println("----Turn: " + turn + "----");
                if (turn++ % 2 != 0) {
                    isFightEnded = makeHit(monster, human, fightCallback);
                } else {
                    isFightEnded = makeHit(human, monster, fightCallback);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private Boolean makeHit(Character defender, Character attacker, Main.FightCallback fightCallback) {
        int damage;
        int random = (int) (Math.random() * 10);

        if (random % 2 == 0) {
            damage = attacker.attack(defender);
        } else {
            damage = attacker.attack(defender);
        }

        if (damage != 0 && random % 2 > 0) {
            System.out.println(String.format("%s Hit with critical %d damage!", attacker.getName(), damage));
            System.out.println(String.format("%s has left %d health points...", defender.getName(), defender.getHealth()));
        } else if (damage != 0 && random % 2 == 0) {
            System.out.println(String.format("%s Hit with %d damage!", attacker.getName(), damage));
            System.out.println(String.format("%s has left %d health points...", defender.getName(), defender.getHealth()));
        } else {
            System.out.println(String.format("%s missed!", attacker.getName()));
        }


        if (defender.getHealth() <= 0 && defender instanceof Human) {
            System.out.println("Sorry, you died...");
            fightCallback.fightLost();
            return true;
        } else if (defender.getHealth() <= 0) {
            System.out.println(String.format("You won! You've got %d exp and %d gold!", defender.getExp(), defender.getGold()));
            attacker.setExp(attacker.getExp() + defender.getExp());
            attacker.setGold(attacker.getGold() + defender.getGold());
            fightCallback.fightWin();
            return true;
        } else {
            return false;
        }
    }
}