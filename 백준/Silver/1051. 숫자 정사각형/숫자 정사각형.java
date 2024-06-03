import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String rectangleSize = br.readLine();
        int N = Integer.parseInt(rectangleSize.split(" ")[0]);
        int M = Integer.parseInt(rectangleSize.split(" ")[1]);

        char[][] rectangleBoard = new char[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            rectangleBoard[i] = line.toCharArray();
        }
        System.out.println(findPerfectSquare(rectangleBoard, N, M));
    }

    public static int findPerfectSquare(char[][] rectangleBoard, int N, int M) {
        int oneSide = Math.min(N,M);
        /*
        (0,0) (0,1) (0,2)
        (1,0) (1,1) (1,2)
        (2,0) (2,1) (2,2)
         */
        for(int maxSide = oneSide; maxSide > 0; maxSide--) {
            for(int i = 0; i <= N - maxSide; i++) {
                for(int j = 0; j <= M - maxSide; j++) {
                    if(rectangleBoard[i][j] == rectangleBoard[i + maxSide -1][j]
                            && rectangleBoard[i + maxSide -1][j] == rectangleBoard[i + maxSide - 1][j + maxSide -1]
                            && rectangleBoard[i + maxSide - 1][j + maxSide -1] == rectangleBoard[i][j + maxSide -1]) {
                        return maxSide * maxSide;
                    }
                }
            }
        }
        return 1;
    }
}
