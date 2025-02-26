import java.util.*;

class Solution {
    public List<Integer> solution(int n) {
        
        List<Integer> list = new ArrayList<>();
        
        while (n != 1) {
            list.add(n);
            
            if (n % 2 == 0) n /= 2;
            else n = 3 * n + 1;
            
        }
        
        list.add(1);
        
        return list;
    }
}