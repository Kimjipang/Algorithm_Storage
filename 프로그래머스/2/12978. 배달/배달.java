import java.util.*;

class Solution {
    private static ArrayList<int[]>[] adjList;
    private static int[] dist;
    
    private static void calculateDist() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        pq.add(new int[] {1, 0});
        dist[1] = 0;
        
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int dest = arr[0];
            int cost = arr[1];
            
            if (dist[dest] < cost) {
                continue;
            }
            
            for (int[] next : adjList[dest]) {
                if (dist[next[0]] > cost + next[1]) {
                    dist[next[0]] = cost + next[1];
                    pq.add(new int[] {next[0], dist[next[0]]});
                }
            }
        }
    }
    public int solution(int N, int[][] road, int K) {
        /*
        N은 최대 50
        road 최대 2,000
        
        1. 인접리스트 만들어서 각 마을까지 걸리는 시간을 Integer.MaxValue()로 잡는다
        2. 다이렉트로 마을에 갈 수 있는 방법과 건너 갈 수 있는 방법 중 더 작은 것으로 값을 바꾼다.
        3. K보다 작으면 count++ 하고 최종 반환
        */
        
        int answer = 0;
        adjList = new ArrayList[N + 1];
        dist = new int[N + 1];
        
        int n = road.length;
        
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            adjList[road[i][0]].add(new int[] {road[i][1], road[i][2]});
            adjList[road[i][1]].add(new int[] {road[i][0], road[i][2]});
        }
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        calculateDist();
        
        for (int num : dist) {
            if (num <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}