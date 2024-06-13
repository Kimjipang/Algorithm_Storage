import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int compareNum = 0;

        for(int i = 0; i < 10; i++) {
            int score = Integer.parseInt(br.readLine());
            sum += score;
            
            if (Math.abs(100 - sum) <= Math.abs(100 - compareNum)) {
                compareNum = sum;
            }
        }
        
        System.out.println(compareNum);
    }
}
