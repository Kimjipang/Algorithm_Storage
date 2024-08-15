import java.util.*;

class Solution {
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        return bfs(0, 0, maps);
        
    }
    private static int bfs(int x, int y, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 1});
        visited[x][y] = true;
        
        
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int curX = arr[0];
            int curY = arr[1];
            int count = arr[2];
            
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