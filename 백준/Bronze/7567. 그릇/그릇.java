import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] stack = br.readLine().split("");

        String standard = stack[0];
        int height = 10;

        for(int i = 1; i < stack.length; i++) {
            if(standard.equals(stack[i])) {
                height += 5;
                standard = stack[i];
            }
            else {
                height += 10;
                standard = stack[i];
            }
        }
        System.out.println(height);
    }
}
