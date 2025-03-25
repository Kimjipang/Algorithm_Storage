import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        /*
        prices의 길이가 최대 100,000이기 때문에 O(N^2) 불가.
        */
        int len = prices.length;
        int[] answer = new int[len];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        stack.addLast(0);
        
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peekLast()]) {
                int j = stack.pollLast();
                answer[j] = i - j;
            }
            stack.addLast(i);
        }
        
        while (!stack.isEmpty()) {
            int j = stack.pollLast();
            answer[j] = len - 1 - j;
        }
        
        return answer;
    }
}