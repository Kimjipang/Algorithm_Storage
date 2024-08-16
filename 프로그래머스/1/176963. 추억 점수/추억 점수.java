import java.util.*;


class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        int name_len = name.length;
        int photo_len = photo.length;
        
        for (int i = 0; i < name_len; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for (int j = 0; j < photo_len; j++) {
            int sum = 0;
            int len = photo[j].length;
            for (int k = 0; k < len; k++) {
                if (map.containsKey(photo[j][k])) {
                    sum += map.get(photo[j][k]);
                }
            }
            answer[j] = sum;
            
        }
        
        return answer;
    }
}