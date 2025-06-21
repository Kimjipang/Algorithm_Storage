import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int from = commands[i][0] - 1;
            int to = commands[i][1];
            int k = commands[i][2];
            
            // 최대 힙 (내림차순 Comparator 사용)
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
            
            for (int j = from; j < to; j++) {
                pq.offer(array[j]);
                if (pq.size() > k) {
                    pq.poll(); // 가장 큰 값 제거 → k개 유지
                }
            }
            
            result[i] = pq.peek(); // k번째 작은 수
        }
        
        return result;
    }
}
