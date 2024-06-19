import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        int count = 0, reload = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i+1])
                count ++;
            else {
                count = 0;
                reload ++;
            }
        }
        int[] answer = new int[reload + 1];
        int index = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] != arr[i+1])
                answer[index++] = arr[i];
        }
        answer[index] = arr[arr.length-1];
        return answer;
    }
}