import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            int result = 0;
            for(int j = 1; j < num; j++) {
                if(j + j * j > num) {
                    break;
                }
                else {
                    result = j;
                }
            }
            System.out.println(result);
        }
    }
}
