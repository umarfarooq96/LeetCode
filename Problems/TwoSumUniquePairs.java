import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSumUniquePairs {

    public static int twoSum(int[] nums, int target) {
        int results = 0;

        //first get rid of all duplicates -- not needed as 1+5 = 5+1
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }
        ArrayList<Integer> uniqueNumsList = new ArrayList<>(uniqueNums);

        //use this map to see if you have a number which can be used to make target
        HashMap<Integer, Integer> complimentNumIndex = new HashMap<>();
        for (int i = 0; i < uniqueNumsList.size(); i++) {
            Integer num = uniqueNumsList.get(i);
            //if there is a number which can be used to make target, we add to results
            if (complimentNumIndex.containsKey(num)) {
                results++;
            } else {
                //otherwise, we'll remember this and keep looking
                int compliment = target - num;
                complimentNumIndex.put(compliment, i);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 45, 46, 46 };
        System.out.println(twoSum(nums, 47));
    }
}
