import java.util.*;

class Solution {
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int numbers_len = numbers.length;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        for (int i = 0; i < numbers_len; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int num = queue.poll();
                queue.add(num + numbers[i]);
                queue.add(num - numbers[i]);
            }
        }
        
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num == target) {
                answer++;
            }
        }
        return answer;
    }
}