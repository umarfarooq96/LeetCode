import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] seen = new int[n];
        int[] low  = new int[n];
        Arrays.fill(seen, -1);
        List<Integer>[]     graph = new ArrayList[n];
        List<List<Integer>> res   = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int len = connections.size();
        // graph
        for (int i = 0; i < len; i++) {
            // p -> q
            int p = connections.get(i).get(0);
            int q = connections.get(i).get(1);
            graph[p].add(q);
            graph[q].add(p);
        }

        // not seen, dfs
        for (int i = 0; i < n; i++) {
            if (seen[i] == -1) {
                dfs(i, low, seen, graph, res, 0);
            }
        }
        return res;
    }

    private void dfs(int u, int[] low, int[] seen, List<Integer>[] graph, List<List<Integer>> res, int node) {
        seen[u] = low[u] = ++time;
        for (int j = 0; j < graph[u].size(); j++) {
            int v = graph[u].get(j);
            if (v == node) {
                continue;
            }
            if (seen[v] == -1) {
                dfs(v, low, seen, graph, res, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > seen[u]) {
                    res.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], seen[v]);
            }
        }
    }
}