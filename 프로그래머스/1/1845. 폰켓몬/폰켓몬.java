import java.util.*;

class Solution {
    private static HashSet<Integer> phoneketmon;
    private static int n;
    
    private static void initSet(int[] nums) {
        phoneketmon = new HashSet<>();
        
        for (int num : nums) phoneketmon.add(num);
    }
    
    private static int choosePhoneketmon() {
        int size = phoneketmon.size();
        
        return size < n / 2 ? size : n / 2;
    }
    
    public int solution(int[] nums) {
        /*
        nums의 최대 길이 10,000 O(N^2) 이하로 해결
        
        [풀이]
        선택 가능한 폰켓몬은 N/2마리이며 최대한 많은 종류의 폰켓몬을 선택해야 함.
        집합에 모든 폰켓몬 종류 초기화
        집합의 길이가 N/2보다 작으면 집합의 길이 return하고 N/2 이상이면 N/2 return
        */
        initSet(nums);
        n = nums.length;
        
        int answer = choosePhoneketmon();
        return answer;
    }
}