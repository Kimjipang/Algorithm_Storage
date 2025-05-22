import java.util.*;

class Solution {
    private static ArrayList<Character> list;
    private static ArrayDeque<Character> stack;
    private static int n;
    
    private static boolean isPossible() {
        stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            char ch = list.get(i);
            
            if (ch == ']' || ch == ')' || ch == '}') {
                if (stack.isEmpty()) return false;
                else {
                    char c = stack.peek();
                    if (ch == ']' && c == '[') stack.pop();
                    else if (ch == ')' && c == '(') stack.pop();
                    else if (ch == '}' && c == '{') stack.pop();
                }
            }
            else stack.push(ch);
        }
        
        return stack.size() == 0 ? true : false;
    }
    public int solution(String s) {
        /*
        s 최대 길이는 1,000이기에 O(N^2) 초과하는 시간복잡도는 불가
        
        [풀이]
        stack 선언해서 s를 전부 push
        pop하면서 올바른 괄호 여부 확인
        
        한 번 확인 끝났으면 앞에 인덱스 요소 제거해서 뒤로 add
        */
        
        int answer = 0;
        n = s.length();
        list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) { // n
            list.add(s.charAt(i));
        }
        
        for (int i = 0 ; i < n; i++) { // n^2
            char ch = list.get(0);
            
            if (isPossible()) answer++;
            list.remove(0);
            list.add(ch);
        }
        
        return answer;
    }
}