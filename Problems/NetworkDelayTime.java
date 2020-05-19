import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class NetworkDelayTime {

    public static void main(String[] args) {
        System.out.println(new NetworkDelayTime().networkDelayTime(new int[][] {
              { 2, 1, 1 },
              { 2, 3, 1 },
              { 3, 4, 1 }
        }, 4, 2));
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        K--;
        N--;
        //djisktra
        HashMap<Integer, Set<Edge>> outGoingEdges = new HashMap<>();

        for (int[] time : times) {
            int  source = time[0] - 1;
            int  target = time[1] - 1;
            int  weight = time[2] - 1;
            Edge e      = new Edge(source, target, weight);
            if (!outGoingEdges.containsKey(source)) {
                outGoingEdges.put(source, new HashSet<>());
            }
            outGoingEdges.get(source).add(e);
        }

        int[] minTimeToGetHere = new int[N + 1];
        for (int i = 0; i < minTimeToGetHere.length; i++) {
            minTimeToGetHere[i] = Integer.MAX_VALUE;
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(K);
        Queue<Integer> q = new ArrayDeque<>();
        minTimeToGetHere[K] = 0;
        q.add(K);

        while (!q.isEmpty()) {
            int cur           = q.poll();
            int costToGetHere = minTimeToGetHere[cur];
            if (outGoingEdges.get(cur) != null) {
                for (Edge e : outGoingEdges.get(cur)) {
                    int destination     = e.to;
                    int costToGetToDest = costToGetHere + e.weight;
                    minTimeToGetHere[destination] = Math.min(minTimeToGetHere[destination], costToGetToDest);
                    if (!visited.contains(destination)) {
                        q.add(destination);
                    }
                }
                visited.add(cur);
            }
        }

        System.out.println(Arrays.toString(minTimeToGetHere));

        return 0;
    }
}

class Edge {

    int from;
    int to;
    int weight;

    Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}