import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        두개의 소수를 곱한 값이 K, 소수 * 소수는 소수이기 때문에 K도 소수
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        BigInteger K = new BigInteger(input[0]);
        int L = Integer.parseInt(input[1]);


        for(int i = 2; i < L; i++) {
            BigInteger num = BigInteger.valueOf(i);
            if(K.mod(num).equals(BigInteger.ZERO)) {
                System.out.println("BAD " + i);
                return;
            }
        }
        System.out.println("GOOD");
    }
}
