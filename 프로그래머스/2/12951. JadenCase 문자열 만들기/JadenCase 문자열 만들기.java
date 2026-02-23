import java.util.*;

class Solution {
    public String solution(String s) {
        String lower = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        boolean isStart = true; // 현재 문자가 단어의 시작인지
        
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            
            if (isStart && Character.isLetter(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }
            
            // 공백 다음 문자는 단어 시작
            isStart = (c == ' ');
        }
        
        return sb.toString();
    }
}