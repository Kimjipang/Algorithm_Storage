import java.util.*;

class Solution {
    private static ArrayDeque<Integer> stack;
    
    private static int[] calculatePrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        stack = new ArrayDeque<>();

        
        if (n == 2) return new int[] {1, 0};
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()])  {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int j = stack.pop();
            
            answer[j] = n - 1 - j;
        }
        
        return answer;
    }
    
    public int[] solution(int[] prices) {
        /*
        prices 최대 길이 100,000이기에 O(N^2)미만의 시간 복잡도로 해결
        
        [풀이]
        
        */
        int[] answer = calculatePrices(prices);
        
        return answer;
    }
}