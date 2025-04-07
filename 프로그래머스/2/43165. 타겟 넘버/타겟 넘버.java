import java.util.*;

class Solution {
    static ArrayDeque<Integer> queue;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = bfs(numbers, target);
        
        return answer;
    }
    private int bfs(int[] numbers, int target) {
        int len = numbers.length;
        int result = 0;
        
        queue = new ArrayDeque<>();
        queue.addLast(0);
        
        for (int i = 0; i < len; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int num = queue.pollFirst();
                queue.addLast(num + numbers[i]);
                queue.addLast(num - numbers[i]);
            }
        }
        
        while (!queue.isEmpty()) {
            if (queue.pollFirst() == target) result++;
        }
        
        return result;
    }
}