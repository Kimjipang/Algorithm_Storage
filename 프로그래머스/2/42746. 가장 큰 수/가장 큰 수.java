import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        /*
        
        */
        int n = numbers.length;
        String[] arr = new String[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (arr[0].equals("0")) return "0";
        
        return String.join("", arr);
    }
}