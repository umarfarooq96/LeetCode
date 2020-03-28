public class Search2dMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        /*
        start in bottom left
        if target > this, we move right
        if this > target, we move up

        we can get stuck if it's between 2 row/col values -- if so, then return false immediatley;
        */

        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int curRow = matrix.length - 1;
        int curCol = 0;
        int curVal = matrix[curRow][curCol];

        while (curVal != target) {

            if (target > curVal) {
                curCol++;
            } else if (curVal > target) {
                curRow--;
            }

            if (curRow >= matrix.length || curRow < 0 || curCol >= matrix[0].length || curCol < 0) {
                return false;
            }

            curVal = matrix[curRow][curCol];
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
              { 1, 4, 7, 11, 15 },
              { 2, 5, 8, 12, 19 },
              { 3, 6, 9, 16, 22 },
              { 10, 13, 14, 17, 24 },
              { 18, 21, 23, 26, 30 }
        };
        System.out.println(searchMatrix(matrix, 5));
    }
}
