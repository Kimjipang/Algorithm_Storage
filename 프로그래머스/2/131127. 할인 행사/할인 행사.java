import java.util.*;

class Solution {
    private static HashMap<String, Integer> fruits;
    private static int n;
    private static int total;
    
    private static void initHashMap(String[] want, int[] number) {
        fruits = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            fruits.put(want[i], number[i]);
        }    
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        /*
        want, number의 최대 길이 10
        discount의 최대 길이 100,000
        discount * number의 총합 최대치가 10,000,000 이기에 시간 복잡도면에서 가능함.
        
        [풀이]
        1. want를 key, number를 value로 하는 hashmap을 초기화
        2. discount를 순회하면서 number의 총 수만큼 key에 해당하는 value를 -1한다.
        3. 이후 모든 value가 0이면 result++;
        */
        int answer = 0;
        
        n = want.length;
        initHashMap(want, number);
        
        int num = discount.length;
        
        for (int i = 0; i <= num - 10; i++) {
            HashMap<String, Integer> purchased = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                String fruit = discount[j];
                if (fruits.containsKey(fruit)) {
                    purchased.put(fruit, purchased.getOrDefault(fruit, 0) + 1);
                }
            }
            
            if (fruits.equals(purchased)) answer++;
        }
        
        return answer;
    }
}