import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] ints = { 2, 3, 6, 7 };
        System.out.println(combinationSum(ints, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public static void combinationSum(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target,
                                      int start) {
        /*
        if target == 0, this is a good result
        if target > 0, keep going
        if target < 0, don't go further and return
         */
        if (target == 0) {
            result.add(new ArrayList<>(cur));
        }

        if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                /*
                we keep subtracting until we get our candidate
                i.e, target 7, we'll get to {2,2,2,2}, that gets tossed, we come back to remove
                then we go from {2,2,2} and try all the next ones, {2,2,2,3}, etc.
                then we go from {2,2} and try all the next ones, {2,2,3} works, so add it, {2,2,6}, etc.
                then we go from {2} and try all the next ones, {2,3}, etc.
                ...
                when we try {3}, we won't try {3,2, ...} because our start is already passed 2.
                    that is, we tried all combinations with 2's.
                 */
                cur.add(candidates[i]);
                combinationSum(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
