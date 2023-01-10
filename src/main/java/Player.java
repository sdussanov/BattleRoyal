import java.util.Arrays;
import java.util.Objects;

public class Player extends Human {
    Backpack backpack;

    public Player(String name) {
        super(name);
        backpack = new Backpack();
    }

    public void take(String item) {
        backpack.put(item);
    }


    class Backpack {
        String[] items = new String[6];
        private int counter = 0;

        public void put(String item) {
            if (counter < items.length) {
                items[counter++] = item;
            } else {
                System.out.println("No more items!");
            }
        }

        @Override
        public String toString() {
            if (counter == 0) {
                return "The backpack is empty!";
            }
            return Arrays.toString(Arrays.stream(items).filter(Objects::nonNull).toArray(String[]::new)).replace("[", "").replace("]", "") +
                    " in the backpack!";
        }
    }
}
