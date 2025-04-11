import java.util.*;

class Solution {
    static ArrayDeque<int[]> queue;
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        answer = bfs(maps);
        return answer;
    }
    
    private static int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        queue = new ArrayDeque<>();
        visited = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        queue.addLast(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] arr = queue.pollFirst();
            int curX = arr[0];
            int curY = arr[1];
            int count = arr[2];
            
            if (curX == n - 1 && curY == m - 1) {
                return count;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if (nextX >= 0 && nextY >= 0 && nextX <= n - 1 && nextY <= m - 1) {
                    if (!visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.addLast(new int[] {nextX, nextY, count + 1});
                    }
                }
            }
        }
        return -1;
    }
}