import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String[] words = new String[num];

        for(int i = 0; i < num; i++) {
            words[i] = br.readLine();
        }

        for(String word : words) {
            String compare = "";
            for(int i = word.length() - 1; i >= 0; i--) {
                compare += word.charAt(i);
            }
            if(Arrays.asList(words).contains(compare)) {
                System.out.println(word.length() + " " + word.charAt(word.length() / 2));
                break;
            }
        }
    }
}
