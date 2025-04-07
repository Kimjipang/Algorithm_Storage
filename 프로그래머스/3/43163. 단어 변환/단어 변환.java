import java.util.*;

class Solution {
    static ArrayDeque<String[]> queue;
    static Map<String, Integer> visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin, target, words);
        
        return answer;
    }
    
    private int bfs(String begin, String target, String[] words) {
        int n = words.length;
        
        queue = new ArrayDeque<>();
        visited = new HashMap<>();
        
        queue.addLast(new String[] {begin, "0"});
        visited.put(begin, 1);
        
        while (!queue.isEmpty()) {
            String[] arr = queue.pollFirst();
            String from = arr[0];
            int num = Integer.parseInt(arr[1]);
            
            if (from.equals(target)) {
                return num;
            }
            
            for (int i = 0; i < n; i++) {
                String to = words[i];
                if (!visited.containsKey(to) && isConvertable(from, to)) {
                    queue.addLast(new String[] {to, String.valueOf(num + 1)});
                    visited.put(to, 1);
                }
            }
        }
        return 0;
    }
    
    private boolean isConvertable(String from, String to) {
        int n = from.length();
        int num = 0;
        
        for (int i = 0; i < n; i++) {
            if (from.charAt(i) != to.charAt(i)) {
                num += 1;
            }
        }
        
        if (num == 1) return true;
        
        return false;
    }
}