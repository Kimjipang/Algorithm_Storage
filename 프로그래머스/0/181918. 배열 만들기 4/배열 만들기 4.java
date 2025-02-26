import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        
        int i = 0;
        int len = arr.length;
        
        while (i < len) {
            if (stk.isEmpty()) {
                stk.add(arr[i]);
                i += 1;
            }
            
            else {
                if (stk.get(stk.size() - 1) < arr[i]) {
                    stk.add(arr[i]);
                    i += 1;
                }
                
                else stk.remove(stk.size() - 1);
            }
        }
        
        return stk;
    }
}