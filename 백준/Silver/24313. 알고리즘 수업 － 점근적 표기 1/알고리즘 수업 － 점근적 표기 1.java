import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        f(n) <= C * g(n)

        f(n) = a1*n + a0

        모든 n >= n0에 대해 a1*n + a0 <= C*n 가 존재
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String twoNum = br.readLine();
        int a1 = Integer.parseInt(twoNum.split(" ")[0]);
        int a0 = Integer.parseInt(twoNum.split(" ")[1]);

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        boolean isSatisfied = true;

        for (int n = n0; n <= 100; n++) {
            if (a1 * n + a0 > c * n) {
                isSatisfied = false;
                break;
            }
        }

        if (isSatisfied) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
