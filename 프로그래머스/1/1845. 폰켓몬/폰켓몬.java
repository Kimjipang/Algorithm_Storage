
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        
        HashSet<Integer> pocketmon = new HashSet<>();
        
        for (int num : nums) pocketmon.add(num);
        
        int size =  pocketmon.size();
        if (size >= n / 2) return n / 2;
        
        answer = size;
        
        return answer;
    }
}