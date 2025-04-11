import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        /*
        array의 길이는 최대 100
        commands의 길이는 50이하
        */
        int n = commands.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            int[] command = commands[i];
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = command[0] - 1; j < command[1]; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(command[2] - 1);
        }
        
        return answer;
    }
}