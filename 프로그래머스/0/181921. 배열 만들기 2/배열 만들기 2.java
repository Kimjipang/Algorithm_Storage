import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = l; i <= r; i++) {
            String num = Integer.toString(i);
            String[] arr = num.split("");
            int cnt = 0;
            
            for (String str : arr) {
                if (!str.equals("0") && !str.equals("5")) {
                    cnt += 1;
                }
            }
            
            if (cnt == 0) list.add(Integer.parseInt(num));
        }       
        
        if (list.size() == 0) list.add(-1);
        
        return list;
    }
}