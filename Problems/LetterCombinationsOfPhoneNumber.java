import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    static Map<Character, String> digitMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(letterCombinations("2345"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> answers = new ArrayList<>();
        digitMap.put('1', "");
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");

        helper(answers, digits, "");
        return answers;
    }

    public static void helper(List<String> answers, String curDigits, String curCombo) {
        if (curDigits.length() == 0) {
            answers.add(curCombo);
            return;
        }

        Character curDigit = curDigits.charAt(0);
        String    rest     = curDigits.substring(1);
        for (char letter : digitMap.get(curDigit).toCharArray()) {
            String combo_added = curCombo + new Character(letter).toString();
            helper(answers, rest, combo_added);
        }
    }
}
