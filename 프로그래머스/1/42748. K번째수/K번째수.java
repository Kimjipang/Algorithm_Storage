import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int[] command : commands) {
            int from = command[0] - 1;
            int to = command[1];
            int idx = command[2] - 1;
            
            int[] copiedArr = Arrays.copyOfRange(array, from, to); 
            
            Arrays.sort(copiedArr);
            list.add(copiedArr[idx]);
        }
        
        return list.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}