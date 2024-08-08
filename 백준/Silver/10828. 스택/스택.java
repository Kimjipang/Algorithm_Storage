import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<>();
        String command = "";
        int element = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            command = s.split(" ")[0];
            switch (command) {
                case "push":
                    stack.add(Integer.parseInt(s.split(" ")[1]));
                    break;
                case "pop":
                    if (stack.size() == 0) {
                        System.out.println(-1);
                        break;
                    }
                    else {
                        int num = 0;
                        num = stack.remove(stack.size() - 1);
                        System.out.println(num);
                        break;
                    }
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.size() == 0) {
                        System.out.println(1);
                        break;
                    }
                    else {
                        System.out.println(0);
                        break;
                    }
                case "top":
                    if (stack.size() == 0) {
                        System.out.println(-1);
                        break;
                    }
                    else {
                        System.out.println(stack.get(stack.size() - 1));
                        break;
                    }
            }
        }
    }
}
