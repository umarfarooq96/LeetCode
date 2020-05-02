import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak(
              "abcd",
              List.of("a", "abc", "b", "cd")));
    }

    static Boolean[] validWordBreak;

    public static boolean wordBreak(String s, List<String> wordDict) {
        validWordBreak = new Boolean[s.length()];
        Set<String> setOfWords = new HashSet<>();
        for (String word : wordDict) {
            setOfWords.add(word);
        }

        return wordBreakHelper(s, setOfWords, 0);
    }

    /**
     * can we make s (from position "start" to end) with setOfWords
     */
    public static boolean wordBreakHelper(String s, Set<String> setOfWords, int start) {
        if (s.length() == 0) return true;

        //if we've already done this computation before, then we don't have to do redo it.
        if (validWordBreak[start] != null) {
            return validWordBreak[start];
        }

        boolean found = false;
        for (int i = 0; i <= s.length(); i++) {
            //check if s[0..i] is a valid decomposition of s
            String sub = s.substring(0, i);
            if (setOfWords.contains(sub)) {
                //if it is a valid decomposition, check the rest of the string
                found = wordBreakHelper(s.substring(i), setOfWords, i);
                //if all of s can be made, then we can remember this in memo
                if (found) {
                    validWordBreak[start] = true;
                    return true;
                }
            }
        }
        validWordBreak[start] = false;
        return found;
    }
}
