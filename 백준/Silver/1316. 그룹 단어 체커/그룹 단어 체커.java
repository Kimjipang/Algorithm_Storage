import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (isGroupWord(str)) {
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean isGroupWord(String str) {

        Stack<Character> stack = new Stack<>();

        stack.push(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            if (!stack.peek().equals(str.charAt(i)) && stack.contains(str.charAt(i))) {
                return false;
            }
            else {
                stack.push(str.charAt(i));
            }
        }
        return true;
    }
}
