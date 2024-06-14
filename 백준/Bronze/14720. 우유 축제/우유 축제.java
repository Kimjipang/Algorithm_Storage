import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        우유 마시는 규칙 : 딸기우유(0) -> 초코우유(1) -> 바나나우유(2) -> 딸기우유
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> milkQueue = new LinkedList<>();
        milkQueue.add(0);
        milkQueue.add(1);
        milkQueue.add(2);

        int result = available(milkQueue, N, st);

        System.out.println(result);
    }
    private static int available(Queue<Integer> milkQueue, int N, StringTokenizer st) {
        int maxDrinkable = 0;

        for(int i = 0; i < N; i++) {
            int currentMilk = milkQueue.peek();
            if(Integer.parseInt(st.nextToken()) == currentMilk) {
                maxDrinkable++;
                milkQueue.poll();
                milkQueue.add(currentMilk);
            }
        }
        return maxDrinkable;
    }
}
