import java.util.*;

class Solution {
    public int[] solution(String s) {
        /*
        중복된 원소 있을 수 있음
        순서가 다르면 서로 다른 튜플
        
        [풀이]
        s 최대 1,000,000이고 return하는 배열의 길이가 최대 500이하
        문자열 중에서 중괄호 안 원소가 1개인 놈이 배열의 0번째 요소

        */
        s = s.substring(0, s.length() - 2).replace("{", "");
        String[] arr = s.split("},");
        
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            String[] numbers = arr[i].split(",");
            
            for (String number : numbers) {
                
                if (!set.contains(number)) {
                    answer[i] = Integer.parseInt(number);
                    set.add(number);
                }
            }
        }
        
        return answer;
    }
}