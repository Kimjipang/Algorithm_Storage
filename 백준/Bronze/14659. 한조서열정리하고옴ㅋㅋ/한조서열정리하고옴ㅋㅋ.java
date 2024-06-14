import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        N의 크기 최대 30,000, 이중 for문으로 해결하면 최대 900,030,000번 + ∂ 연산해야 함.
        1억번에 1초면 이중 for문 안될 거 같음.


         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] hanzo = new int[num];

        for(int i = 0; i < num; i++) {
            hanzo[i] = Integer.parseInt(input[i]);
        }

        int maxKill = 0;

        int result = killLog(hanzo, maxKill);
        System.out.println(result);


    }

    private static int killLog(int[] hanzo, int maxKill) {
        int len = hanzo.length;

        for(int i = 0; i < len - 1; i++) {
            int count = 0;
            for(int j = i + 1; j < len; j++) {
                if(hanzo[i] >= hanzo[j]) {
                    count++;
                }
                else {
                    break;
                }
            }
            maxKill = Math.max(count, maxKill);
        }
        return maxKill;
    }
}
