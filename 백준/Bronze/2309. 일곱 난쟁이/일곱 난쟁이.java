import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        1. 7개를 조합해서 100이 나오는 것 중 아무거나 출력하면 된다. 조합은 재귀로... 어렵다 ㅠㅠ
        2. 9개 중 2개를 아무거나 뺐을 때, 100이 되면 그 리스트를 반환하면 됨. 이것도 사실 9개 중 2개를 뽑는 것이기 때문에 조합이기는 하다. 그래도 2개만 뽑는 거라 훨씬 간단!

        메모리
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] smuff = new int[9];
        int total = 0;

        for(int i = 0; i < 9; i++) { // 난쟁이 9명 초기화
            smuff[i] = Integer.parseInt(br.readLine());
            total += smuff[i];
        }

        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(total - smuff[i] - smuff[j] == 100) { // total에서 임의의 값 2개 뺐을 때, 100이라면 값을 0으로 초기화해 break;
                    smuff[i] = 0;
                    smuff[j] = 0;
                    Arrays.sort(smuff);
                    for (int k = 2; k < 9; k++) { // 2번째 요소부터 순회. 0,1 번째 요소는 0으로 초기화했으니!
                        System.out.println(smuff[k]);
                    }
                    return;
                }
            }
        }
    }
}