public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
              { 'A', 'B', 'C', 'E' },
              { 'S', 'F', 'E', 'S' },
              { 'A', 'D', 'E', 'E' }
        };
        System.out.println(exist(board, "ABCESEEEFS"));
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || word.equals("")) return false;
        if (board.length == 0 || board[0].length == 0) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {

                    boolean[][] visited = new boolean[board.length][board[0].length];
                    boolean[]   found   = { false };
                    DFS(board, visited, i, j, word, found);
                    if (found[0]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void DFS(char[][] board, boolean[][] visited, int i, int j, String word, boolean[] result) {
        if (word.length() == 0) {
            result[0] = true;
            return;
        }
        if (word.length() == 1) {
            if (board[i][j] == word.charAt(0) && !visited[i][j]) {
                result[0] = true;
                return;
            }
        }
        if (board[i][j] == word.charAt(0) && !visited[i][j]) {
            String newWord = word.substring(1);
            visited[i][j] = true;

            if (i - 1 > 0) { //up
                DFS(board, visited, i - 1, j, newWord, result);
            }
            if (i + 1 < board.length) { //down
                DFS(board, visited, i + 1, j, newWord, result);
            }
            if (j - 1 > 0) { //left
                DFS(board, visited, i, j - 1, newWord, result);
            }
            if (j + 1 < board[0].length) { //right
                DFS(board, visited, i, j + 1, newWord, result);
            }
        }
    }
}
