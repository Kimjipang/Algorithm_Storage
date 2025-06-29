import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        /*
        구명보트 1개에는 최대 100kg, 최대한 적은 구명보트를 사용해야 함.
        people의 최대 수는 50,000 O(N^2) 이하로 ㄱㄱ
        
        
        */
        int answer = 0;
        int i = 0;
        int j = people.length - 1;
        Arrays.sort(people);
        
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            
            j -= 1;
            answer++;
        }
        
        return answer;
    }
}