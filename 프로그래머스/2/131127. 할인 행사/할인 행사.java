import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        /*
        want -> 원하는 제품
        number -> 제품의 수량
        
        
        1. want를 key, number를 value로 하는 map을 생성
        2. discount를 0번째 요소부터 discount.length - number 총 수 + 1까지 순회
        */
        
        int answer = 0;
        int len = want.length;
        int n = discount.length;
        
        for (int i = 0; i < n - 10 + 1; i++) {
            Map<String, Integer> map = new HashMap<>();
            int count = 0;
            
            for (int k = 0; k < len; k++) {
            map.put(want[k], number[k]);
            }
            
            for (int j = i; j < i + 10; j++) {
                if (map.containsKey(discount[j]) && map.get(discount[j]) != 0){
                    map.put(discount[j], map.get(discount[j]) - 1);
                }
                else break;
                if (map.get(discount[j]) == 0) count++;
                
            }
            
            if (count == len) answer++;
        }
        
        return answer;
    }
}