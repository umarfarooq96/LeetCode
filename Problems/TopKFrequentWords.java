import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        Set<String>       strings       = wordCount.keySet();
        ArrayList<String> sortedStrings = new ArrayList<>(strings);
        sortedStrings.sort((w1, w2) -> wordCount.get(w1).equals(wordCount.get(w2)) ?
                                       w1.compareTo(w2) : wordCount.get(w2) - wordCount.get(w1));

        return sortedStrings.subList(0, k);
    }
}
