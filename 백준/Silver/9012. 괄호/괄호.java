import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            boolean isItEmpty = true;
            
            for (int j = 0; j < s.length; j++) {
                if (s[j].equals("(")) {
                    stack.push(s[j]);
                }
                else {
                    if (stack.isEmpty()) {
                        isItEmpty = false;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }

            }
            if (!stack.isEmpty()) {
                isItEmpty = false;
            }
            if (isItEmpty) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
