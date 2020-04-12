import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class RandomizedSet {

    final List<Integer>             list;
    final HashMap<Integer, Integer> valLocation; //value -> index map
    Random rand = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        valLocation = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valLocation.containsKey(val)) {
            return false;
        }
        System.out.println("inserted " + val);
        list.add(val);
        valLocation.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!valLocation.containsKey(val)) {
            return false;
        }
        /*
        swap val to the end of the list
        update indecies
        */
        System.out.println("removed " + val);
        System.out.println(list.toString());
        System.out.println(valLocation.toString());
        int valIndex = valLocation.get(val);
        valLocation.remove(val);

        Integer valAtEnd = list.get(list.size() - 1);
        list.set(valIndex, valAtEnd);
        valLocation.put(valAtEnd, valIndex);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

class Runner {

    public static void main(String[] args) {
        RandomizedSet obj     = new RandomizedSet();
        boolean       param_1 = obj.insert(0);
        boolean       param_2 = obj.remove(0);
        int           param_3 = obj.getRandom();
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such: RandomizedSet obj = new RandomizedSet(); boolean
 * param_1 = obj.insert(val); boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
