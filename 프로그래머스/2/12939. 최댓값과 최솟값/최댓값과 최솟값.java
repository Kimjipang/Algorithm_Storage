import java.util.*;

class Solution {
    public String solution(String s) {
        /*
        문자열 s를 배열로 만들어서 정렬 후 0번째 인덱스와 마지막 인덱스를 answer에 더하면 됨.
        */
        String answer = "";
        String[] str = s.split(" ");
        int len = str.length;
        
        int[] arr = new int[len];
        
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        
        Arrays.sort(arr);
        
        answer += arr[0] + " " + arr[len - 1];
       
        return answer;
    }
}