import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpiralMatrixOutput {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<>();

        List<Integer> res = new LinkedList<>();
        int           n   = matrix.length, m = matrix[0].length;

        int up   = 0, down = n - 1;
        int left = 0, right = m - 1;

        while (res.size() < n * m) {
            //top row
            for (int j = left; j <= right && res.size() < n * m; j++) {
                res.add(matrix[up][j]);
            }

            //right column
            for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++) {
                res.add(matrix[i][right]);
            }

            //bottom row
            for (int j = right; j >= left && res.size() < n * m; j--) {
                res.add(matrix[down][j]);
            }

            //left column
            for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--) {
                res.add(matrix[i][left]);
            }

            left++;
            right--;
            up++;
            down--;
        }

        return res;
    }
}
