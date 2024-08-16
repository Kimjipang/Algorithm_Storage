import java.util.*;


class Solution {
    
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        visited = new boolean[words.length];
        
        answer = bfs(words, begin, target);
        
        return answer;
    }
    private static int bfs(String[] words, String begin, String target) {
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int words_len = words.length;
            
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    System.out.println(count);
                    return count;
                }
                
                for (int j = 0; j < words_len; j++) {
                    if (!visited[j] && possibleConvert(cur, words[j])) {
                        queue.add(words[j]);
                        visited[j] = true;
                    }
                }
            }
            count++;
        }
        return 0;
    }
    private static boolean possibleConvert(String begin, String target) {
        int len = begin.length();
        int diff_count = 0;
        for (int i = 0; i < len; i++) {
            if (!begin.substring(i, i+1).equals(target.substring(i, i+1))) {
                diff_count++;
            }
        }
        if (diff_count == 1) {
            return true;
        }
        return false;
    }
}