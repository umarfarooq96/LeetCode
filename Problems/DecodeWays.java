public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }

    /*
    EX: "2261"
    "" = 1 way to decode

    "2" = 1 way to decode

    "22" = if "2" is usable then we have all the decodings of "2"
           if "22" is usable then we have all the decodings of ""

    "226" = if "6" is usable then we have all the decodings of "22"
            if "26" is usable then we have all the decodings of "2"

    "2261" = if "1" is usable then we have all the decodings of "226"
             "61" is NOT usable so we don't have all the decodings of "22"
     */
    public static int numDecodings(String s) {
        int[] numOfWaysToDecodeSubstring = new int[s.length() + 1];
        numOfWaysToDecodeSubstring[0] = 1;
        numOfWaysToDecodeSubstring[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int numWaysToDecodeString = 0; //without the new character
            int newChar               = Integer.parseInt(s.substring(i - 1, i));
            int newTwoDigitChar       = Integer.parseInt(s.substring(i - 2, i));

            if (newChar != '0') {
                numWaysToDecodeString += numOfWaysToDecodeSubstring[i - 1]; //
            }
            if (newTwoDigitChar > 0 && newTwoDigitChar <= 26) {
                numWaysToDecodeString += numOfWaysToDecodeSubstring[i - 2];
            }

            numOfWaysToDecodeSubstring[i] = numWaysToDecodeString;
        }
        return numOfWaysToDecodeSubstring[s.length()];
    }
}
