public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] x = {
              { '1', '1', '1', '1', '0' },
              { '1', '1', '0', '1', '0' },
              { '1', '1', '0', '0', '0' },
              { '0', '0', '0', '0', '0' }
        };

        System.out.println(numIslands(x));
    }

    public static int numIslands(char[][] grid) {
        /*
        note that
        11000
        11000
        00100
        00011
        is basically equivalent to
        10000
        00000
        00100
        00001

        in other words, if we just reduce the island to be as small as possible then
        it makes traversing a bit easier
        alternatively, could mark as visited too -- but this will take extra memory
        */
        if (grid == null || grid.length == 0) return 0;

        char[][] gridCopy = new char[grid.length][grid[0].length];
        copyOver(grid, gridCopy);
        int numIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (gridCopy[i][j] == '1') {
                    reduceIsland(gridCopy, i, j); //this will reduce the island'
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    public static void reduceIsland(char[][] grid, int i, int j) {
        if (grid[i][j] == '0') {
            return;
        }
        System.out.println("looking at " + i + " " + j);
        grid[i][j] = '0';
        if (i > 0) { //left
            reduceIsland(grid, i - 1, j);
        }
        if (i < grid.length) { //right
            reduceIsland(grid, i + 1, j);
        }
        if (j > 0) { //up
            reduceIsland(grid, i, j - 1);
        }
        if (j < grid[0].length) { //down
            reduceIsland(grid, i, j + 1);
        }
    }

    public static void copyOver(char[][] grid, char[][] gridCopy) {
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, gridCopy[i], 0, grid[0].length);
        }
    }
}
