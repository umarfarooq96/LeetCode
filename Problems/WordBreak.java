import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak(
              "abcd",
              List.of("a", "abc", "b", "cd")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;

        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }

        boolean found = false;
        for (int i = 0; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (set.contains(sub)) {
                System.out.println(sub);
                found = wordBreak(s.substring(i), wordDict);
                if (found) {
                    return true;
                }
            }
        }

        return found;
    }
}
