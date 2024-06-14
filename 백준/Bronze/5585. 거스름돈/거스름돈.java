import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int price = Integer.parseInt(br.readLine());
        int change = 1000 - price;
        int count = 0;
        int[] exchange = {500, 100, 50, 10, 5, 1};
        
        int result = calculate(change, count, exchange);
        
        System.out.println(result);

    }
    
    private static int calculate(int change, int count, int[] exchange) {
        int len = exchange.length;

        while(change != 0) {
            for(int i = 0; i < len; i++) {
                if(change - exchange[i] < 0) {
                    continue;
                }
                change -= exchange[i];
                count++;
                break;
            }
        }
        
        return count;
    }
}
