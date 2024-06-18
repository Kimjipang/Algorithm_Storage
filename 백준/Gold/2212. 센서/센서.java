import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensors = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; ++i)
            sensors[i] = Integer.parseInt(input[i]);

        Arrays.sort(sensors);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N - 1; ++i)
            pq.add(sensors[i + 1] - sensors[i]);

        int result = 0;
        int count = pq.size() - K + 1;

        for (int i = 0; i < count; ++i)
            result += pq.poll();

        System.out.println(result);
    }
}
