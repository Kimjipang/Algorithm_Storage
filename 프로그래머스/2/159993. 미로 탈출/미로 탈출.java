import java.util.*;

class Solution {
    private static String[] maze;
    private static boolean[][] visited;
    private static int row, col;
    private static ArrayDeque<int[]> queue;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    
    private static int[] findDestination(char ch) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maze[i].charAt(j) == ch) return new int[] {i, j};
            }
        }
        return new int[] {0, 0};
    }
    
    private static int toDestination(int[] from, int[] to) {
        visited = new boolean[row][col];
        queue = new ArrayDeque<>();
        
        int startX = from[0];
        int startY = from[1];
        int toX = to[0];
        int toY = to[1];
        
        queue.addLast(new int[] {startX, startY, 0});
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] arr = queue.pollFirst();
            int curX = arr[0];
            int curY = arr[1];
            int count = arr[2];
            
            if (curX == toX && curY == toY) return count;
            
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col) {
                    if (!visited[nextX][nextY] && maze[nextX].charAt(nextY) != 'X') {
                        visited[nextX][nextY] = true;
                        queue.addLast(new int[] {nextX, nextY, count + 1});
                    }
                }
            }
        }
        
        return -1;
    }
    
    
    public int solution(String[] maps) {
        /*
        maps 최대 100 X 100
        
        [풀이]
        레버를 당기고 탈출 가능
        레버까지 최단 거리 구하고, 레버에서 탈출구까지 최단 거리 구해서 합하기
        */
        maze = maps;
        row = maps.length;
        col = maps[0].length();

        
        int[] start = findDestination('S');
        int[] lever = findDestination('L');
        int[] exit = findDestination('E');
        
        int toLever = toDestination(start, lever);
        int toExit = toDestination(lever, exit);
        
        if (toLever == -1 || toExit == -1) return -1;
        
        return toLever + toExit;
    }
}