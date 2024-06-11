import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        시간 제한 2초
        수빈이의 위치 N
        동생의 위치 K

        수빈이가 걷는 속도 1초에 현 위치(X) - 1 or 현 위치(X) + 1
        순간이동은 1초에 2*X
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        if(N >= K) {
            System.out.println(N - K);
            return;
        }

        int[] time = new int[100001];
        boolean[] visited = new boolean[100001];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            int [] nextPositions = {cur - 1, cur + 1, cur * 2}; // 나올 수 있는 경우의 수 nextPositons에 초기화

            for(int next : nextPositions) {
                if(next == K) { // next가 K면 전 위치까지 도달하기 위해 소요된 시간 + 1 출력하고 return
                    System.out.println(time[cur] + 1);
                    return;
                }
                
                
                if(next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true; // 방문 기록
                    time[next] = time[cur] + 1; // 전 위치까지 도달하기 위해 소요된 시간 + 1
                    queue.add(next);
                }
            }
        }
    }
}
