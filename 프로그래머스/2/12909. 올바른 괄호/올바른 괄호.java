import java.util.*;

class Solution {
    private static ArrayDeque<Character> stack;
    
    private static boolean isCorrect(String s) {
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            if (ch == ')') {
                if (stack.isEmpty()) return false;
                else {
                    if (stack.peek() == '(') stack.pop();
                }
            }
            
            else stack.push(ch);
        }
        
        return stack.size() == 0 ? true : false;
        
    }
    boolean solution(String s) {
        /*
        s 길이 최대 100,000이기에 O(N^2) 미만의 시간 복잡도로 해결해야 함.
        
        [풀이]
        • 스택 선언
        • 스택이 비어있을 때
            • 닫힌 괄호면 false 반환
            • 열린 괄호면 일단 스택에 push
        • 스택이 안 비어있을 때
            • peek()한 값이 닫힌 괄호면 false
            • 열린 괄호면 pop()
        • 마지막에 스택 비어있으면 true
        */
        stack = new ArrayDeque<>();
        
        boolean answer = isCorrect(s);

        return answer;
    }
}