import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String boardSize = br.readLine();
        int N = Integer.parseInt(boardSize.split(" ")[0]);
        int M = Integer.parseInt(boardSize.split(" ")[1]);

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
        }

        int minCount = Integer.MAX_VALUE;

        // 8x8 부분 보드를 찾아서 검사
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minCount = Math.min(minCount, findMinCount(board, i, j));
            }
        }

        System.out.println(minCount);
    }

    public static int findMinCount(char[][] board, int x, int y) {
        String[] patterns = {"WBWBWBWB", "BWBWBWBW"};

        int count1 = 0; 
        int count2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[x + i][y + j] != patterns[i % 2].charAt(j)) {
                    count1++;
                }
                if (board[x + i][y + j] != patterns[(i + 1) % 2].charAt(j)) {
                    count2++;
                }
            }
        }

        return Math.min(count1, count2);
    }
}
