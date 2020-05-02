import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinations(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    void combinations(List<List<Integer>> answers, List<Integer> currentCombination, int[] candidates, int start,
                      int targetLeft) {
        //if we've made the target, then this is an answer -- add it to answers
        if (targetLeft == 0) {
            answers.add(new ArrayList<>(currentCombination));
        }
        //if we still have some sum left to add, then we can keep trying
        if (targetLeft > 0) {
            for (int i = start; i < candidates.length; i++) {
                //since we are sorted, we basically ignore consecutive elements which are the same
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                //pick the ith element and continue parsing the tree of choices
                currentCombination.add(candidates[i]);
                combinations(answers, currentCombination, candidates, i + 1, targetLeft - candidates[i]);
                //now don't pick the ith element, continue the loop so we decide with the rest of the elements
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}
