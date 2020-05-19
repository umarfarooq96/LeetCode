public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq(
              "abcabcabcabc"));
    }

    public int longestPalindromeSubseq(String s) {
        /*
        aaabbbaab = ?
        it's the max of aaabbbaa, aabbbaab
        aaabbbaa = ?
        a......a so it's the 1 + max of aabbba
        aabbba = ?
        a....a so it's 1 + max of abbb
        abbb = ?
        it's the max of abb or bbb


        if i..j is a palindrome, then i-1..j+1 is a palindrome only if i-1 and j+1 are the same -- this is for contiguous substring

        */
        return lps(s, 0, s.length() - 1);
    }

    public int lps(String s, int start, int end) {
        if (end >= s.length() || start < 0) return 0; //something like empty string almost
        System.out.println(s.substring(start, end + 1));
        if (end == start) return 1;
        if (end - start + 1 == 2) return s.charAt(start) == s.charAt(end) ? 2 : 1; //aa is a palindrome, ab is not
        // if(end - start == 3) return s.charAt(start) == s.charAt(end) ? 3 : 1; //aba is a palindrome, abc is not

        if (s.charAt(start) == s.charAt(end)) {
            return 1 + lps(s, start + 1, end - 1);
        }
        return Math.max(lps(s, start + 1, end), lps(s, start, end - 1));
    }
}
