import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        Map<String, Integer> countMap = new HashMap<>();

        for(int i = 0; i < num; i++) {
            String extension = br.readLine().split("\\.")[1];
            countMap.put(extension, countMap.getOrDefault(extension, 0) + 1);
        }

        Map<String, Integer> sortedMap = new TreeMap<>(countMap);
        
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
