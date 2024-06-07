import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        ArrayList<String> university = new ArrayList<>();

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int maxAmount = Integer.MIN_VALUE;
            for(int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                String univName = input[0]; // 대학 이름 초기화
                int alcohol = Integer.parseInt(input[1]); // 술 양 초기화

                if(maxAmount < alcohol) { // maxAmount < alcohol일 때만, university 배열에 대학 이름 add
                    maxAmount = alcohol;
                    university.add(univName);
                }
            }
            // 내부 for문이 끝났을 때, 가장 맨 끝 요소가 술 양이 제일 많은 대학임.
            System.out.println(university.get(university.size() - 1));
        }
    }
}
