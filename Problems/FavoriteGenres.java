import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class FavoriteGenres {

    public static Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs,
                                                           Map<String, List<String>> songGenres) {
        Map<String, List<String>> result = new HashMap<>();

        for (String user : userSongs.keySet()) {
            result.put(user, new ArrayList<>());
        }

        Map<String, String> songToGenre = new HashMap<>();

        //takes O(songs) time -- we look at each song from the genreToSongMap
        for (Entry<String, List<String>> genreToSongs : songGenres.entrySet()) {
            String genre = genreToSongs.getKey();
            for (String song : genreToSongs.getValue()) {
                songToGenre.put(song, genre);
            }
        }

        //O(u*s*g) -- for each user, we look at all of their songs as a genre, and then we insert those into a priority queue
        //which sorts the genres in O(n) time where n is # genres => u*s*g
        Map<String, Map<String, Integer>> userToGenreCountMap = new HashMap<>();
        for (String user : userSongs.keySet()) {
            userToGenreCountMap.put(user, new HashMap<>());

            List<String> genresOfUser = userSongs.get(user).stream()
                                                 .map(songToGenre::get)
                                                 .collect(Collectors.toList());

            for (String genre : genresOfUser) {
                Map<String, Integer> genreToCountMap = userToGenreCountMap.get(user);
                genreToCountMap.put(genre, genreToCountMap.getOrDefault(genre, 0) + 1);
            }

            Queue<Entry<String, Integer>> queue =
                  new PriorityQueue<>((g1, g2) -> g2.getValue().compareTo(g1.getValue()));
            queue.addAll(userToGenreCountMap.get(user).entrySet());

            Entry<String, Integer> topGenre = queue.poll();
            result.get(user).add(topGenre.getKey());
            while (queue.peek().getValue().equals(topGenre.getValue()) && !queue.isEmpty()) {
                result.get(user).add(queue.poll().getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, List<String>> userSongs  = new HashMap<>();
        Map<String, List<String>> songGenres = new HashMap<>();
        userSongs.put("David", List.of("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", List.of("song5", "song6", "song7"));

        songGenres.put("Rock", List.of("song1", "song3"));
        songGenres.put("Dubstep", List.of("song7"));
        songGenres.put("Techno", List.of("song2", "song4"));
        songGenres.put("Pop", List.of("song5", "song6"));
        songGenres.put("Jazz", List.of("song8", "song9"));

        System.out.println(favoriteGenres(userSongs, songGenres));
    }
}
