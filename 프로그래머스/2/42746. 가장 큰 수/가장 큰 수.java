import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] arr = Arrays.stream(numbers)
                                .mapToObj(String::valueOf)
                                .toArray(String[]::new);
        
        Arrays.sort(arr, (num1, num2) -> (num2 + num1).compareTo(num1 + num2));
        
        for (String str : arr) {
            answer.append(str);
        }
        
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer.toString();
    }
}