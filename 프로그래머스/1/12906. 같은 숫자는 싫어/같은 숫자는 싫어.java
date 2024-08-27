import java.util.*;

public class Solution {
    
    public int[] solution(int []arr) {
        int len = arr.length;
        int num = arr[0];
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(num);
        
        for (int i = 1; i < len; i++) {
            if (num != arr[i]) {
                list.add(arr[i]);
                num = arr[i];
            }
        }
        
        int size = list.size();
        int[] answer = new int[size];
        
        for (int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}