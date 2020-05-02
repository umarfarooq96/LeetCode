import java.util.LinkedList;
import java.util.Queue;

public class MaxOfMinAltitudes {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 1 } };
        System.out.println(maximumPath(matrix));
    }

    private static int maximumPath(int[][] matrix) {
        //this is done to basically wipe out the first and last values and replace them with other viable values
        matrix[0][0] = matrix[1][0];
        matrix[matrix.length - 1][matrix[0].length - 1] = matrix[1][0];

        int             maxPath = Integer.MIN_VALUE;
        Queue<PathNode> queue   = new LinkedList<>();
        queue.add(new PathNode(0, 0, matrix[0][0]));

        while (queue.size() > 0) {
            PathNode curPath = queue.poll();

            maxPath = Integer.max(maxPath, curPath.smallest);

            if (curPath.i + 1 < matrix.length) {
                int valGoingDown = matrix[curPath.i + 1][curPath.j];
                queue.add(new PathNode(curPath.i + 1, curPath.j, Integer.min(curPath.smallest, valGoingDown)));
            }
            if (curPath.j + 1 < matrix[0].length) {
                int valGoingRight = matrix[curPath.i][curPath.j + 1];
                queue.add(new PathNode(curPath.i, curPath.j + 1, Integer.min(curPath.smallest, valGoingRight)));
            }
        }

        return maxPath;
    }

    static class PathNode {

        int smallest;
        int i;
        int j;

        PathNode(int i, int j, int smallest) {
            this.smallest = smallest;
            this.i = i;
            this.j = j;
        }
    }
}
