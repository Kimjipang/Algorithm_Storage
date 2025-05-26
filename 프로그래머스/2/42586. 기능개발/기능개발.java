import java.util.*;

class Solution {
    private static ArrayDeque<Integer> deque;
    
    private static void calculate(int[] progresses, int[] speeds) {
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
        /*
        두 배열 모두 최대 길이 100이기에 O(N^3) 이하의 시간 복잡도로 해결하면 됨.
        
        [풀이]
        각 얼마나 걸리는지를 담는 배열을 초기화
        */
        deque = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        calculate(progresses, speeds);
        
        int num = deque.pollFirst();
        int count = 1;
        
        while (!deque.isEmpty()) {
            int num2 = deque.pollFirst();
            
            if (num >= num2) count++;
            else {
                list.add(count);
                num = num2;
                count = 1;
            }
        }
        
        list.add(count);
                
        return list.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}