import java.util.*;

class Solution {
    public int solution(int[] nums) {
        /*
        nums의 길이는 최대 10,000이기에 O(N^2) ㄴㄴ
        
        [풀이]
        1. 집합에 nums를 저장
        2. 길이가 N/2이상이면 N/2 return
        2-1. N/2 미만이면 집합의 길이 return
        */
        
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        int n = set.size();
        int len = nums.length;
        
        return n >= (len / 2) ? (len / 2) : n;
    }
}