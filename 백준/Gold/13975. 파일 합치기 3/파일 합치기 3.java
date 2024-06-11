import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        StringBuilder sb = new StringBuilder();
        int cases = Integer.parseInt(br.readLine());

        for(int i = 0; i < cases; i++) {
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            
            for(int j = 0; j < num; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            
            long total = 0;
            while(pq.size() > 1) {
                long x = pq.poll();
                long y = pq.poll();
                long sum = x + y;
                total += sum;
                pq.add(sum);
            }
            sb.append(total + "\n");
        }
        System.out.printf(sb.toString());
    }
}
