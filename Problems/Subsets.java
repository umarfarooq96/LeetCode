import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] ints = { 3, 2, 1 };
        System.out.println(subsetsWithDup(ints));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    @SuppressWarnings("ConstantConditions")
    public static void helper(List<List<Integer>> allSubsets, List<Integer> subset, int[] originalNumbers,
                              int decisions) {
        //if we make 3 decisions of add/ignore then we can add (i.e, the lowest level of the decision tree)
        if (decisions == originalNumbers.length) {
            allSubsets.add(new ArrayList<>(subset));
            return;
        }
        //our choice here is to ignore, we continue the tree
        subset = subset;
        helper(allSubsets, subset, originalNumbers, decisions + 1);

        //our choice here is to add, continue the tree
        subset.add(originalNumbers[decisions]);
        helper(allSubsets, subset, originalNumbers, decisions + 1);

        //now we step back
        subset.remove(subset.size() - 1);
    }
}
