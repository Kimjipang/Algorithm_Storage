import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(str[i]));
        }

        Collections.sort(list);
        int result = 0;

        while (list.size() >= 1) {
            for (int i = 0; i <= list.size() - 1; i++) {
                result += list.get(i);
            }
            list.remove(list.size() - 1);
        }

        System.out.println(result);
    }
}