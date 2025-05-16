import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int n = numbers.length;
        String[] arr = new String[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = "" + numbers[i];
        }
        
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (arr[0].equals("0")) return "0";
        
        for (String str : arr) {
            answer += str;
        }
        
        return answer;
    }
}