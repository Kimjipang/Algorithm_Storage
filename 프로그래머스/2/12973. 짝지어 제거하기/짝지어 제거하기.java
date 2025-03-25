import java.util.*;

class Solution {
    public int solution(String s) {
        /*
        s가 최대 1,000,000이기에 O(N^2)는 안됨.
        */
        int answer = 0;
        int len = s.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            
            if (!stack.isEmpty() && stack.peekLast() == ch) stack.pollLast();
            else stack.addLast(ch);
        }
        
        if (stack.isEmpty()) return 1;
        
        return answer;
    }
}