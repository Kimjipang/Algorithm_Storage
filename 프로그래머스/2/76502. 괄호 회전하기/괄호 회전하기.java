import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            if (isPossible(s, len)) {
                answer++;
            }
            
            s = shift(s);
        }
        return answer;
    }
    private static boolean isPossible(String s, int len) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') { // 열린 괄호면 스택에 push
                stack.push(ch);
            }
            else { // 닫힌 괄호의 경우
                if (stack.isEmpty()) return false;
                else if (stack.peek() == '(' && ch == ')') stack.pop();
                else if (stack.peek() == '[' && ch == ']') stack.pop();
                else if (stack.peek() == '{' && ch == '}') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
    private static String shift(String s) {
        return s.substring(1) + s.charAt(0);
    }
}