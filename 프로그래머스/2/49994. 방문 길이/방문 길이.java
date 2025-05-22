import java.util.*;

class Solution {
    private static HashMap<String, int[]> direction;
    private static HashSet<String> answer;
    private static boolean isAvailableMove(int x, int y) {
        if (x >= 0 && y >= 0 && x < 11 && y < 11) return true;
        
        return false;
        
    }
    
    public int solution(String dirs) {
        /*
        좌표평면을 10 X 10 크기로 만든다.
        배열은 음수 인덱스가 없기에 원점을 (5, 5)로 둔다.
        */
        answer = new HashSet<>();
        direction = new HashMap<>();
        
        direction.put("U", new int[] {0, 1});
        direction.put("D", new int[] {0, -1});
        direction.put("R", new int[] {1, 0});
        direction.put("L", new int[] {-1, 0});
        
        
        String[] arr = dirs.split("");
        int curX = 5;
        int curY = 5;
        
        for (String to : arr) {
            int[] info = direction.get(to);
            int nextX = curX + info[0];
            int nextY = curY + info[1];
            
            if (!isAvailableMove(nextX, nextY)) {
                continue;
            }
            
            answer.add(curX + " " + curY + ", " + nextX + " " + nextY);
            answer.add(nextX + " " + nextY + ", " + curX + " " + curY);
            
            curX = nextX;
            curY = nextY;
        }
        
        return answer.size() / 2;
    }
}