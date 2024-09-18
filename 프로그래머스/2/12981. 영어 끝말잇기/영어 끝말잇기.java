import java.util.*;

class Solution {
    
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        Set<String> visited = new HashSet<>();
        int len = words.length;
               
        visited.add(words[0]);
        char ch = words[0].charAt(words[0].length() - 1);
        
        for (int i = 1; i < len; i++) {
            String word = words[i];
            char firstCh = word.charAt(0);
            if (visited.contains(word) || firstCh != ch) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            visited.add(word);
            ch = word.charAt(word.length() - 1);
        }

        return answer;
    }
}