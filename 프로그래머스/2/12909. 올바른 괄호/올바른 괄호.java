import java.util.*;

class Solution {
    boolean solution(String s) {
        /*
        스택을 만들고, s를 순회한다.
        괄호짝이 나오면 pop() 2번하고, 짝이 없으면 push()
        순회가 끝나고 stack에 길이가 0이면 true 반환
        
        제한 사항 100,000 
        */
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        boolean answer = true;
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') stack.push(ch);
            
            else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                else {
                    stack.push(ch);
                }
            }
        }

        answer = stack.isEmpty();

        return answer;
    }
}