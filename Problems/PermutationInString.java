public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("ab", "eidbaooo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] s1Map    = charMap(s1);
        int[] s2CutMap = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            int idx = s2.charAt(i) - 'a';
            s2CutMap[idx]++;
        }

        //s1 = "ab" s2 = "eidbaooo"
        if (permCheck(s1Map, s2CutMap)) return true;

        int start = 0;
        for (int end = s1.length(); end < s2.length(); end++) {
            int start_idx = s2.charAt(start) - 'a';
            int end_idx   = s2.charAt(end) - 'a';
            s2CutMap[start_idx]--;
            s2CutMap[end_idx]++;
            start++;
            if (permCheck(s1Map, s2CutMap)) return true;
        }

        return permCheck(s1Map, s2CutMap);
    }

    boolean permCheck(int[] map1, int[] map2) {
        for (int i = 0; i < map1.length; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }

    int[] charMap(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            chars[idx]++;
        }
        return chars;
    }
}
