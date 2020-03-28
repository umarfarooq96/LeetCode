import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        Orange[][] orangeGrid = new Orange[grid.length][grid[0].length];
        int        numOranges = 0;
        int        numRotten  = 0;

        Queue<Orange> orangeQueue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    numOranges++;
                    Orange orange = new Orange();
                    orangeGrid[i][j] = orange;

                    if (grid[i][j] == 2) {
                        numRotten++;
                        orange.rotten = true;
                        orangeQueue.add(orange);
                    }
                }
            }
        }

        for (int i = 0; i < orangeGrid.length; i++) {
            for (int j = 0; j < orangeGrid[i].length; j++) {
                if (orangeGrid[i][j] != null) {
                    Orange orange = orangeGrid[i][j];
                    if (j - 1 >= 0) {
                        orange.left = orangeGrid[i][j - 1];
                    }
                    if (j + 1 < orangeGrid[i].length) {
                        orange.right = orangeGrid[i][j + 1];
                    }
                    if (i - 1 >= 0) {
                        orange.up = orangeGrid[i - 1][j];
                    }
                    if (i + 1 < orangeGrid.length) {
                        orange.down = orangeGrid[i + 1][j];
                    }
                }
            }
        }

        int minutes = 0;
        while (!orangeQueue.isEmpty()) {
            Set<Orange> newlyRottenOranges = new HashSet<>();
            while (!orangeQueue.isEmpty()) {
                Orange poll = orangeQueue.poll();
                newlyRottenOranges.add(poll);
            }

            for (Orange newlyRottenOrange : newlyRottenOranges) {
                if (newlyRottenOrange.up != null && !newlyRottenOrange.up.rotten) {
                    Orange up = newlyRottenOrange.up;
                    up.rotten = true;
                    orangeQueue.add(up);
                    numRotten++;
                }
                if (newlyRottenOrange.down != null && !newlyRottenOrange.down.rotten) {
                    Orange down = newlyRottenOrange.down;
                    down.rotten = true;
                    orangeQueue.add(down);
                    numRotten++;
                }
                if (newlyRottenOrange.left != null && !newlyRottenOrange.left.rotten) {
                    Orange left = newlyRottenOrange.left;
                    left.rotten = true;
                    orangeQueue.add(left);
                    numRotten++;
                }
                if (newlyRottenOrange.right != null && !newlyRottenOrange.right.rotten) {
                    Orange right = newlyRottenOrange.right;
                    right.rotten = true;
                    orangeQueue.add(right);
                    numRotten++;
                }
            }
            if (!orangeQueue.isEmpty()) {
                minutes++;
            }
        }

        return numRotten == numOranges ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] ints = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(orangesRotting(ints));
    }

    static class Orange {

        public Orange  up;
        public Orange  down;
        public Orange  left;
        public Orange  right;
        public boolean rotten = false;
    }
}
