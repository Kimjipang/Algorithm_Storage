import java.util.*;

class Solution {
    private static ArrayDeque<Character> stack;
    
    public int solution(String s) {
        /*
        문자열 길이 최대 100만이기에 O(N^2) 미만의 시간 복잡도로 해결해야 함.
        
        [풀이]
        • 문자열 순회하면서 비어있으면 비어있으면 push()
        • 비어있지 않으면 peek()해서 push()할 문자와 비교해서 같으면 pop() 다르면 push()
        • 순회 끝났을 때 return isEmpty() ? 1 : 0;
        
        시간 복잡도 » O(N)
        */
        stack = new ArrayDeque<>();
        
        int answer = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) stack.push(s.charAt(i));
            
            else {
                if (stack.peek() == s.charAt(i)) stack.pop();
                else stack.push(s.charAt(i));
            }
        }
        

        return stack.isEmpty() ? 1 : 0;
    }
}