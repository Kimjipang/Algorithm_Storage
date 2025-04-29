import java.util.*;

class Solution {
    private static int leverX, leverY, startX, startY, exitX, exitY;
    private static char[][] map;
    
    private static void findPosition() {
        int n = map.length;
        int m = map[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = map[i][j];
                
                if (ch == 'S') {
                    startX = i;
                    startY = j;
                }
                else if (ch == 'L') {
                    leverX = i;
                    leverY = j;
                }                
                else if (ch == 'E') {
                    exitX = i;
                    exitY = j;
                }
            }
        }
    }
    
    private static int bfs(int fromX, int fromY, int toX, int toY) {
        int n = map.length;
        int m = map[0].length;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.addLast(new int[] {fromX, fromY, 0});
        visited[fromX][fromY] = true;
        
        while (!queue.isEmpty()) {
            int[] arr = queue.pollFirst();
            int curX = arr[0];
            int curY = arr[1];
            int count = arr[2];
            
            if (curX == toX && curY == toY) {
                return count;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (!visited[nextX][nextY] && map[nextX][nextY] != 'X') {
                        queue.addLast(new int[] {nextX, nextY, count + 1});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return -1;
    }
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        map = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        findPosition();
        
        int toLeverDist = bfs(startX, startY, leverX, leverY);
        int toExitDist = bfs(leverX, leverY, exitX, exitY);
        System.out.println(toLeverDist + ", " + toExitDist);
        
        if (toLeverDist == -1 || toExitDist == -1) return -1;
        
        return toLeverDist + toExitDist;
    }
}