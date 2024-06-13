import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        시간 복잡도 O(N)

        N개 중에서 5개를 뽑는 것이기 때문에, 조합
        nC5 구하면 된다.
        메모리
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long starNum = 1;
        for(int i = N; i > N - 5; i--) {
            starNum *= i;
        }

        System.out.println(starNum / 120);
    }
}

