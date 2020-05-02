import java.util.Stack;

public class ValidParantheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();

        char[] chars = s.toCharArray();

        for (char bracket : chars) {

            if (bracket == '(' || bracket == '[' || bracket == '{') {
                brackets.push(bracket);
            } else {
                //close bracket
                if (!brackets.isEmpty()) {
                    char lastBracket = brackets.pop();
                    if (bracket == ')' && lastBracket != '(') {
                        return false;
                    }
                    if (bracket == ']' && lastBracket != '[') {
                        return false;
                    }
                    if (bracket == '}' && lastBracket != '{') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return brackets.isEmpty();
    }
}
