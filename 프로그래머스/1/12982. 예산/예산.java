import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        /*
        최대한 많은 부서에게 지원하려면 지원금 적은 순서로 지원해야 함.
        
        [풀이]
        오름차순 정렬 후 앞에서부터 budget에서 빼면서 뺀 값이 0보다 크거나 같을 때까지 count++
        */
        Arrays.sort(d);
        
        int answer = 0;
        
        for (int price : d) {
            budget -= price;
            if (budget < 0) break;
            answer++;
        }
        
        return answer;
    }
}