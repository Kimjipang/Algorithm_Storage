import java.util.*;

class Solution {
    
    private static boolean isValidMove(int dx, int dy) {
        return 0 <= dx && dx < 11 && 0 <= dy && dy < 11;
    }
    
    private static final Map<Character, int[]> location = new HashMap<>();
    
    private static void initLocation() {
        location.put('U', new int[] {0, 1});
        location.put('D', new int[] {0, -1});
        location.put('L', new int[] {-1, 0});
        location.put('R', new int[] {1, 0});
    }
    
    public int solution(String dirs) {
        initLocation();
        int x = 5, y = 5;
        Set<String> answer = new HashSet<>();
        
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int dx = x + offset[0];
            int dy = y + offset[1];
            if (!isValidMove(dx, dy)) continue;
            
            answer.add(x + " " + y + " " + dx + " " + dy);
            answer.add(dx + " " + dy + " " + x + " " + y);
            
            x = dx;
            y = dy;
        }
        
        return answer.size() / 2;
    }
}