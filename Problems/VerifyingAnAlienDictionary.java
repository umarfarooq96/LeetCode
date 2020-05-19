import java.util.Comparator;
import java.util.HashMap;

public class VerifyingAnAlienDictionary {

    public static void main(String[] args) {

    }

    public boolean isAlienSorted(String[] words, String order) {
        /*
        write a comparator from order
        (write a string comparator function)
        compare word[i] with word[i+1]
        */
        HashMap<Character, Integer> ordering = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            ordering.put(order.charAt(i), i);
        }

        Comparator<Character> alien = (c1, c2) -> ordering.get(c2) - ordering.get(c1);

        return false;
    }
}
