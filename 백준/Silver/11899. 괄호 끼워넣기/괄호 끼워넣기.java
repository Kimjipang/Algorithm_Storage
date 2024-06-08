import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        스택으로 하나씩 쌓다가 괄호 쌓 찾으면 pop
        남은 괄호의 개수가 필요한 괄호의 개수
        
        메모리 , 시간
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < input.length; i++) {
            if(stack.isEmpty()) {
                stack.add(input[i]);
            }
            else {
                if(stack.peek().equals("(") && input[i].equals(")")) {
                    stack.pop();
                }
                else {
                    stack.add(input[i]);
                }
            }
        }
        System.out.println(stack.size());

    }
}
