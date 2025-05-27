import java.util.*;

class Solution {
    private static ArrayDeque<Integer> deque;
    
    private static void calculate(int[] progresses, int[] speeds) {
        deque = new ArrayDeque<>();
        int n = progresses.length;
        
        for (int i = 0; i < n; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int count = 0;
            
            while (progress < 100) {
                progress += speed;
                count++;
            }
            
            deque.addLast(count);
        }
        
        
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        calculate(progresses, speeds);
        
        int num1 = deque.pollFirst();
        int count = 1;
        
        while (!deque.isEmpty()) {
            int num2 = deque.pollFirst();
            
            if (num1 < num2) {
                num1 = num2;
                answer.add(count);
                count = 1;
            }
            else count++;
        }
        
        answer.add(count);
        
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}