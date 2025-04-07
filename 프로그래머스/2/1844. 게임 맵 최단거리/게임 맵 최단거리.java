import java.util.*;

class Solution {
    private static ArrayDeque<int[]> queue;
    private static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        answer = bfs(maps);
        
        return answer;
    }
    
    private int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        List<Integer> goals = new ArrayList<>();
        
        queue = new ArrayDeque<>();
        visited = new boolean[n][m];
        
        queue.addLast(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] info = queue.pollFirst();
            int x = info[0];
            int y = info[1];
            int count = info[2];
            
            if (x == n - 1 && y == m - 1) return count;
            
            for (int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];
                
                if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m) {
                    if (!visited[next_x][next_y] && maps[next_x][next_y] == 1) {
                        visited[next_x][next_y] = true;
                        queue.addLast(new int[] {next_x, next_y, count + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}