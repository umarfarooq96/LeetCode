import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SearchSuggestionsSystem {

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        char[]       characters = searchWord.toCharArray();
        List<String> words      = Arrays.asList(products);
        words.sort(Comparator.naturalOrder());

        List<List<String>> results = new ArrayList<>();

        for (int i = 0; i < characters.length; i++) {
            char         curChar       = characters[i];
            List<String> matchingWords = new ArrayList<>();
            for (String word : words) {
                if (word.length() >= i && word.charAt(i) == curChar) {
                    matchingWords.add(word);
                }
            }
            words = matchingWords;
            if (words.size() > 3) {
                results.add(words.subList(0, 3));
            } else {
                results.add(words);
            }
        }

        return results;
    }
}
