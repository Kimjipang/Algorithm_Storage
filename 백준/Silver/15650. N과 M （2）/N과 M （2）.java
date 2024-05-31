import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        시간 제한 : 1초
        자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램

        ** 조건 **
        - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        - 고른 수열은 오름차순이어야 한다.
        - 1 <= M <= N <= 8
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        int[] combination = new int[M];
        generateCombinations(N, M, 1, 0, combination);
    }
    private static void generateCombinations(int N, int M, int start, int depth, int[] combination) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(combination[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {   
            combination[depth] = i;
            generateCombinations(N, M, i + 1, depth + 1, combination);
        }
    }
}