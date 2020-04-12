import java.util.Set;

public class ConcatenatedWords {

    public static void main(String[] args) {
        System.out.println(canWordBeMade("ab", Set.of("a", "b")));
    }

    public static boolean canWordBeMade(String word, Set<String> setOfWords) {
        if (setOfWords.contains(word)) {
            return true;
        }
        if (word.equals("")) {
            return true;
        }
        for (int i = 1; i < word.length(); i++) {
            String firstPart  = word.substring(0, i);
            String secondPart = word.substring(i);
            if (canWordBeMade(firstPart, setOfWords) && canWordBeMade(secondPart, setOfWords)) {
                return true;
            }
        }
        return false;
    }
}
