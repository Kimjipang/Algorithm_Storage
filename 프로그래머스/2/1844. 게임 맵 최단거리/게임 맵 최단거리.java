import java.util.*;

class Solution {
    static int n, m;
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0; 
        
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        answer = bfs(maps);
        
        return answer;
    }
    private static int bfs(int[][] maps) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int curX = position[0];
            int curY = position[1];
            int count = position[2];
            
            if (curX == n - 1 && curY == m - 1) {
                return count;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (maps[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        queue.add(new int[] {nextX, nextY, count + 1});
                        visited[nextX][nextY] = true;
                    }
                } 
            }
        }
        return -1;
    }
}