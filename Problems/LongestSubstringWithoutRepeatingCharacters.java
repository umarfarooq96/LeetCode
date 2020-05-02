import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int    start = 0;
        int    end   = 0;

        int ans = 0;

        Set<Character> currentChars = new HashSet<>();

        while (end < chars.length) {
            if (!currentChars.contains(chars[end])) {
                currentChars.add(chars[end]);
                end++;
            } else {
                while (currentChars.contains(chars[end])) {
                    currentChars.remove(chars[start]);
                    start++;
                }
                currentChars.add(chars[end]);
                end++;
            }

            ans = Math.max(ans, (end - start));
        }

        return ans;
    }
}
