import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while (n > 0) {
            if (n % 3 == 0) {
                n = (n / 3) - 1;
                list.add(3);
            }
            else {
                list.add(n % 3);
                n /= 3;
            }
        }
        
        int size = list.size();
        
        for (int i = size - 1; i >= 0; i--) {
            switch (list.get(i)) {
                case 1:
                    answer += "1";
                    break;
                case 2:
                    answer += "2";
                    break;
                case 3:
                    answer += "4";
                    break;
            }
        }
        return answer;
    }
}