import java.util.*;

class Solution {
    private static ArrayDeque<Node> queue;
    private static boolean[][] visited;
    
    public static class Node {
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
        int n = maps.length;
        int m = maps[0].length;
        
        queue = new ArrayDeque<>();
        visited = new boolean[n][m];
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Node node = new Node(0, 0, 1);
        
        queue.addLast(node);
        
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Node cur = queue.pollFirst();
            int curX = cur.x;
            int curY = cur.y;
            int count = cur.count;
            
            if (curX == n - 1 && curY == m - 1) return count;
            
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (!visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.add(new Node(nextX, nextY, count + 1));
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