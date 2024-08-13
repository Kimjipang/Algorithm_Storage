import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][] visited;
    static int N;
    static int[][] apartment;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        apartment = new int[N][N];
        visited = new boolean[N][N];


        for (int i = 0; i < N; i++){
            String line = br.readLine();
            for (int j = 0; j < N; j++){
                apartment[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> countList = new ArrayList<>();
        
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (apartment[i][j] == 1 && !visited[i][j]){
                    countList.add(bfs(i,j));
                }
            }
        }

        Collections.sort(countList);
        
        System.out.println(countList.size());
        for (int count : countList){
            System.out.println(count);
        }
    }

    private static int bfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (apartment[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        queue.add(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
