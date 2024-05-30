import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static  void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Set<String> set = new HashSet<>();
        /*
        input.substring(0, 1), input.substring(1, 2), input.substring(2, 3),
        */
        for(int i = 1; i < input.length() + 1; i++) {
            int start = 0;
            int end = i;

            while (start < end) {
                set.add(input.substring(start, end));
                start++;
            }
        }

        System.out.println(set.size());
    }
}
