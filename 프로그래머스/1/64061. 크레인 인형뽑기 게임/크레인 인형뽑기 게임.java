import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        /*
        board의 길이는 최대 30, O(N^2) 가능
        board의 요소가 0이면 인형 없는 것이고 숫자 같으면 같은 인형으로 간주
        
        1. moves를 순회하면서 board에서 값을 뺌.
        2. 스택에 값이 없으면 그냥 넣고, 있으면 peek()으로 stack의 top 요소랑 비교
        2-1). 비교해서 같으면 pop(), 다르면 add()
        
        */
        
        int answer = 0;
        int len = moves.length;
        int N = board.length;
    
        ArrayDeque<Integer> stack = new ArrayDeque<>(); // 바구니
        
        for (int i = 0; i < len; i++) {
            int col = moves[i] - 1;
            for (int row = 0; row < N; row++) {
                int doll = board[row][col];

                if (doll != 0) {
                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        board[row][col] = 0;
                        answer += 2;
                        break;
                    }
                    else {
                        stack.push(doll);
                        board[row][col] = 0;
                        break;
                    }
                } 
            }
        }
        
        return answer;
    }
}