class Solution {
    public int solution(int [][]board) {
        int answer = 0;
        int row_len = board.length;
        int column_len = board[0].length;
 
        for (int i = 0; i < row_len; i++) {
            for (int j = 0; j < column_len; j++) {
                if (board[i][j] == 1) {
                    checkSquare(board, i, j);
                }
            }
        }
        
        for (int[] row : board) {
            for (int element : row) {
               if (answer < element) {
                   answer = element;
               } 
            }
        }

        return answer * answer;
    }
    
    private static void checkSquare(int[][] board, int x, int y) {
        
        if (y - 1 < 0 || x - 1 < 0) {
            return;
        }
        else if (y - 1 >= 0 && x - 1 >= 0) {
            int min = board[x - 1][y - 1];
            min = Math.min(Math.min(min, board[x][y - 1]), board[x - 1][y]);
            board[x][y] = min + 1;
            return;
        }
    }
}