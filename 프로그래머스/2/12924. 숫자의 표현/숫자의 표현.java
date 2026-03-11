import java.util.*;

class Solution {
    public int solution(int n) {
        /*
        연속하는 수이기 때문에 짝수는 표현할 수 없음.
        ex). 4, 6, 8은 모두 최소 2로는 나누어 떨어지는데 이들을 연속하는 수의 합으로 표현할 수 없음.
        n부터 2로 나누어 보며 
        */
        int answer = 0;
    
        for (int i = 1; i <= n; i += 2) {
            if (n % i == 0) {
                answer++;
            }
        }
        return answer;
    }
}