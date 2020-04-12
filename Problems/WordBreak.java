import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak(
              "abcd",
              List.of("a", "abc", "b", "cd")));
    }

    static Boolean[] memo;

    public static boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        Set<String> setOfWords = new HashSet<>();
        for (String word : wordDict) {
            setOfWords.add(word);
        }

        return wordBreakHelper(s, setOfWords, 0);
    }

    public static boolean wordBreakHelper(String s, Set<String> setOfWords, int start) {
        if (s.length() == 0) return true;

        if (memo[start] != null) {
            return memo[start];
        }

        boolean found = false;
        for (int i = 0; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (setOfWords.contains(sub)) {
                found = wordBreakHelper(s.substring(i), setOfWords, i);
                if (found) {
                    memo[start] = true;
                    return true;
                }
            }
        }
        memo[start] = false;
        return found;
    }
}
