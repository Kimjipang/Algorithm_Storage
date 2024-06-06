import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        Map<String, Integer> fruitsMap = new HashMap<>();

        for(int i = 0; i < number; i++) {
            String input = br.readLine();
            String fruit = input.split(" ")[0];
            int cnt = Integer.parseInt(input.split(" ")[1]);

            int currentCount = fruitsMap.getOrDefault(fruit, 0);
            fruitsMap.put(fruit, currentCount + cnt);
        }


        int totalNum = 0;
        for(String key : fruitsMap.keySet()) {
            int fruitCnt = fruitsMap.get(key);
            if(fruitCnt == 5) {
                totalNum = fruitCnt;
                break;
            }
        }

        System.out.println(totalNum == 5 ? "YES" : "NO");

    }
}
