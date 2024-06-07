import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];

        String[] input = br.readLine().split(" ");
        int[] solvedTickets = new int[input.length];

        for(int i = 0; i < input.length; i++) {
            solvedTickets[i] = Integer.parseInt(input[i]);
            numArr[i] = i + 1;
        }

        Arrays.sort(solvedTickets);
        int cnt = 0;
        
        for(int i = 0; i < N; i++) {
            if(numArr[i] != solvedTickets[i]) {
                System.out.println(numArr[i]);
                cnt++;
                break;
            }
        }
        if(cnt == 0) {
            System.out.println(solvedTickets[N - 1] + 1);
        }

    }
}
