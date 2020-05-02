public class InterleavingString {

    String    s1;
    String    s2;
    String    s3;
    int[][][] dp;

    public static void main(String[] args) {
        InterleavingString string = new InterleavingString();
        System.out.println(string.isInterleave("aabc",
                                               "abad",
                                               "aabcabad"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        /*
        s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        s1 = "abcc", s2="dbbca", s3="abbcbcac"
        s1 = "bcc", s2="dbbca", s3="bbcbcac"


        dp[i][j][k] --
        */
        dp = new int[s1.length()][s2.length()][s3.length()];

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        helper(0, 0, 0);

        return dp[s1.length() - 1][s2.length() - 1][s3.length() - 1] == 1;
    }

    int helper(int i, int j, int k) {
        if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        }
        //if our strings are done, then we're gucci
        if (s1.length() == i && s2.length() == j && s3.length() == k) {
            dp[i][j][k] = 1;
            return 1;
        }
        //if our s3 is done but we haven't completely used s1 and s3, wrong answer
        if (s3.length() == k && (s1.length() != i || s2.length() != j)) {
            dp[i][j][k] = -1;
            return -1;
        }
        //if the first character of s3 is not the first of s1 or s2, bad interleaving
        if (i < s1.length() && s1.charAt(i) != s3.charAt(k) && j < s2.length() && s2.charAt(j) != s3.charAt(k)) {
            dp[i][j][k] = -1;
            return -1;
        }
        //otherwise, try using s1 first and s2 first
        int usingS1First = 0;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            usingS1First = helper(i + 1, j, k + 1);
        }
        int usingS2First = 0;
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            usingS2First = helper(i, j + 1, k + 1);
        }
        //if either way worked, then we're done
        dp[i][j][k] = (usingS1First == 1 || usingS2First == 1) ? 1 : -1;
        return (usingS1First == 1 || usingS2First == 1) ? 1 : -1;
    }
}
