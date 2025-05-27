import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        /*
        participant의 최대 길이는 100,000임. 시간 복잡도 O(N^2) 미만으로 해결 필수
        
        [풀이]
        1. participant와 completion을 정렬한다.
        2. completion 길이만큼 순회하면서 같은 인덱스 요소에 값이 다르면 완주하지 못한 선수임.
        */
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int n = completion.length;
        
        for (int i = 0; i < n; i++) { // N 최대 100,000
            String participantPerson = participant[i];
            String completionPerson = completion[i];
            
            if (!participantPerson.equals(completionPerson)) {
                return participantPerson;
            }
        }
            
        String answer = participant[n];
        
        return answer;
    }
}