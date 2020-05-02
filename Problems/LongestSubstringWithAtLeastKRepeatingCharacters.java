public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabgfggbcccddd", 3));
    }

    public static int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int[] chars = new int[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i += 1) {
            chars[s.charAt(i) - 'a'] += 1;
        }
        boolean someCharNotKTimes = false;
        for (int count : chars) {
            if (count < k && count > 0) {
                someCharNotKTimes = true;
                break;
            }
        }
        // every char in this string is at least k, so we're done
        if (!someCharNotKTimes) return s.length();

        int result = 0;
        int start  = 0;
        int cur    = 0;
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
}
