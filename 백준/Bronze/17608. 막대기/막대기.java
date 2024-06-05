import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        리스트(스택)의 맨 끝 요소에서부터 앞 요소로 순회하면서
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] allBars = new int[num];
        int cnt = 1;

        for(int i = 0; i < num; i++) {
            allBars[i] = Integer.parseInt(br.readLine());
        }

        int standard = allBars[num - 1];

        for(int i = num - 2; i >= 0; i--) {
            if(i == num - 2 && standard < allBars[i]) {
                cnt++;
                standard = allBars[i];
            }
            else {
                if(standard < allBars[i]) {
                    cnt++;
                    standard = allBars[i];
                }
            }
        }
        System.out.println(cnt);
    }
}