import java.util.*;

class Solution {
    private static ArrayDeque<Integer> stack;
    private static int N;
    
    private static int play(int[][] board, int position) {
        int peeked = 0;
        int count = 0;
        
        for (int i = 0; i < N; i++) { // N 
            if (board[i][position - 1] != 0) {
                peeked = board[i][position - 1];
                board[i][position - 1] = 0;
                break;
            }
        }
        
        if (peeked != 0) {
            if (!stack.isEmpty()) {
                if (stack.peek() == peeked) {
                    stack.pop();
                    count += 2;
                }
                else stack.push(peeked);
            }
            else stack.push(peeked);
        }
        
        return count;
    }
    
    public int solution(int[][] board, int[] moves) {
        /*
        board 최대 길이 30 X 30
        moves 최대 길이 1,000
        
        최대 900,000 연산 횟수
        */
        int answer = 0;
        stack = new ArrayDeque<>();
        N = board.length;
        
        for (int move : moves) { // 최대 1,000
            answer += play(board, move);
        }
        
        return answer;
    }
}