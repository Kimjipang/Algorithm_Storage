import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        1
        22
        333
        4444
        같은 방식으로 수열이 생성되기 때문에, 이중 반복문으로 접근
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        int sum = 0;
        int current = 1; // 시작 값이자 현재 값을 나타내는 current를 1로 초기화
        int count = 0; // 현재 몇 번째 위치인지 체킹

        for(int i = 1; i <= B; i++) {
            for(int j = 0; j < current; j++) {
                count++;
                if(count >= A && count <= B) { // 위치가 A와 B사이일 때만 더하면 됨.
                    sum += current;
                }
                if(count == B) {
                    System.out.println(sum);
                }
            }
            current++;
        }
    }
}
