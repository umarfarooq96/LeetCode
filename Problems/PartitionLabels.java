import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String S) {
        if (S.length() == 0) return new ArrayList<>();

        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (!lastIndex.containsKey(S.charAt(i))) {
                lastIndex.put(S.charAt(i), i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        int           k   = 0;
        while (k <= S.length()) {
            char curChar     = S.charAt(k);
            int  possibleEnd = lastIndex.get(curChar);
            int  i           = k + 1;
            while (i < possibleEnd && i < S.length()) {
                curChar = S.charAt(i);
                if (lastIndex.get(curChar) > possibleEnd) {
                    possibleEnd = lastIndex.get(curChar);
                }
                i++;
            }
            ans.add(possibleEnd - k + 1);
            k = possibleEnd + 1;
        }

        return ans;
    }
}
