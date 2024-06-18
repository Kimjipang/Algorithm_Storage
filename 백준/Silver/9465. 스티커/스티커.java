import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][s];

            for(int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k = 0; k < s; k++) {
                    dp[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j = 1; j < s; j++) {
                dp[0][j] += j == 1 ? dp[1][j - 1] : Math.max(dp[1][j - 2], dp[1][j - 1]);
                dp[1][j] += j == 1 ? dp[0][j - 1] : Math.max(dp[0][j - 2], dp[0][j - 1]);
            }
            System.out.println(Math.max(dp[0][s - 1], dp[1][s - 1]));
        }
    }
}
