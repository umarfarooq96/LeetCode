import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ZeroOneMatrix {

    /*
    The intuition here is that we want any time we update a node to be it's shortest path.
    That is,
        [0,1,1]
        [1,1,1]
        [1,1,0]
    Should never become,
        [0,1,2]
        [1,2,3]
        [2,3,0]

    Because then we need to revisit those 3's to update them again.

    So how? We start from all 0's, update the nearest 1's.
    Then, FROM THOSE NEAREST 1'S WE UPDATE THEIR NEAREST 1'S.

    So we get after first pass (i.e, both starting positions which are initial 0's are taken out),
        [0,1,+]
        [1,+,1]
        [+,1,0]
    Where + is +INF.

    On the BFS queue now, we have all of those 1's queued up. They will update their nearest neighbours as such,
        [0,1,2]
        [1,2,1]
        [2,1,0]

    Since from those 1's we plus 1 and get 2.
     */

    static int m;
    static int n;

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } })));
    }

    public static int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        //we use 0's as starting nodes for BFS
        //set 1's to be MAX_VALUE so we can update them later
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int[] cur_cell = queue.poll();
            int   i        = cur_cell[0];
            int   j        = cur_cell[1];
            for (int[] d : dirs) {
                int new_i = i + d[0];
                int new_j = j + d[1];
                if (valid(new_i, new_j) && matrix[new_i][new_j] > matrix[i][j] + 1) {
                    queue.add(new int[] { new_i, new_j });
                    matrix[new_i][new_j] = matrix[i][j] + 1;
                }
            }
        }

        return matrix;
    }

    private static boolean valid(int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
