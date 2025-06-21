import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] num = String.valueOf(n).split(""); // O(N)
        Arrays.sort(num, Collections.reverseOrder());
        
        String arr = String.join("", num);
        
        answer = Long.parseLong(arr);
        return answer;
    }
}