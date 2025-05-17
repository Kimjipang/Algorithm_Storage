import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        /*
        participant 최대 길이는 100,000명이기 때문에 O(N^2) 불가
        
        */
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int n = completion.length;
        
        for (int i = 0; i < n; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }
        
        String answer = "";
        answer = participant[n];
        
        return answer;
    }
}