import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        /*
        N의 개수가 최대 100개까지 
        
        TreeSet을 이용해서 풀이해보자.
        */
        Set<Integer> set_num = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        
        int len = numbers.length;
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                set_num.add(numbers[i] + numbers[j]);
            }
        }
        
        for (Integer number : set_num) {
            list.add(number);
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}