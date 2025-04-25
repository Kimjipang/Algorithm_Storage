import java.util.*;

class Solution {
    private static ArrayDeque<Node> queue;
    private static int[][] visited;
    
    private static class Node {
        int x;
        int y;
        int count;
        
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    private static int bfs(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int n = maps.length;
        int m = maps[0].length;
        queue = new ArrayDeque<>();
        visited = new int[n][m];
        
        queue.addLast(new Node(0, 0, 1));
        visited[0][0] = 1;
        
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            int curX = node.x;
            int curY = node.y;
            int curCount = node.count;
            if (curX == n - 1 && curY == m - 1) return curCount;
            
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (maps[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                        queue.addLast(new Node(nextX, nextY, curCount + 1));
                        visited[nextX][nextY] = 1;
                    }
                }
            }
        }
        
        return -1;
        
    }
    public int solution(int[][] maps) {
        int answer = 0;
        answer = bfs(maps);
        return answer;
    }
}