import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int people = Integer.parseInt(br.readLine());

        int[] winner = new int[people];

        for(int i = 0; i < people; i++) {
            String[] score = br.readLine().split(" ");
            int[] trick = new int[5];
            int highestRun = Math.max(Integer.parseInt(score[0]), Integer.parseInt(score[1]));
            for(int j = 0; j < 5; j++) {
                trick[j] = Integer.parseInt(score[j + 2]);
            }
            Arrays.sort(trick);

            int len = trick.length;
            winner[i] = highestRun + trick[len - 1] + trick[len - 2];
        }

        Arrays.sort(winner);

        System.out.println(winner[winner.length - 1]);

    }
}
