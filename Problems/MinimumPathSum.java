public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 5 }, { 3, 2, 1 } };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        /*
        algorithm:
        do the opposite path
        add the right or the down, take the min
        grid[i][j] will be the min cost to get there from the bottom right corner


        [1,3,1]
        [1,5,1] -- start
        [4,2,1]

        [1,3,1]
        [1,5,1] -- 2+1
        [4,3,1]

        [1,3,1]
        [1,5,1] -- 4+3
        [7,3,1]

        [1,3,1]
        [1,5,2] -- 1+1
        [7,3,1]

        [1,3,1]
        [1,7,2] -- either 5+2 or 5+3, two ways to go from the end to here.
        [7,3,1]

        ... etc

        */

        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i + 1 < grid.length && j + 1 < grid[0].length) { //look at the right and down
                    grid[i][j] = Integer.min(grid[i][j] + grid[i + 1][j], grid[i][j] + grid[i][j + 1]);
                } else if (i + 1 < grid.length) { //can only look up
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else if (j + 1 < grid[0].length) { //has one to the left
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                }
            }
        }

        return grid[0][0];
    }
}
