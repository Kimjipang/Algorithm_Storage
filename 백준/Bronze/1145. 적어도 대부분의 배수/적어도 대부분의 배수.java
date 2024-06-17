import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] naturalNum = new int[5];

        for(int i = 0; i < 5; i++) {
            naturalNum[i] = Integer.parseInt(st.nextToken());
        }

        int result = 1;
        while(true) {
            int count = 0;
            for(int i = 0; i < 5; i++) {
                if(result % naturalNum[i] == 0) {
                    count++;
                }
            }
            if(count > 2) {
                break;
            }
            result++;
        }
        System.out.println(result);

    }
}
