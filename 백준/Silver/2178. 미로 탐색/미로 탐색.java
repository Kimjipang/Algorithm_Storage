import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] maze = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(maze, N, M));
    }

    public static int bfs(int[][] maze, int N, int M) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0));

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int x = pos.x;
            int y = pos.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && maze[nx][ny] == 1) {
                    maze[nx][ny] = maze[x][y] + 1;
                    queue.add(new Position(nx, ny));
                }
            }
        }

        return maze[N-1][M-1];
    }
}
