import java.util.*;

class Solution {
    /*
    양방향이라는 것 주의
    */
    private static ArrayList<int[]>[] adjList;
    private static PriorityQueue<int[]> pq;
    private static int[] dist;
    
    private static void checkAvailable() {
        pq.add(new int[] {1 , 0});
        dist[1] = 0;
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowTown = now[0];
            int nowDist = now[1];
            if (nowDist > dist[nowTown]) continue;
            
            for (int[] next : adjList[nowTown]) {
                int nextTown = next[0];
                int nextDist = next[1];
                if (dist[nextTown] > nowDist + nextDist) {
                    dist[nextTown] = nowDist + nextDist;
                    pq.add(new int[] {nextTown, dist[nextTown]});
                }
            }
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        adjList = new ArrayList[N + 1];
        pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        dist = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] arr : road) {
            int from = arr[0];
            int to = arr[1];
            int cost = arr[2];
            adjList[from].add(new int[] {to, cost});
            adjList[to].add(new int[] {from, cost});
        }
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        checkAvailable();
        
        for (int num : dist) {
            if (num <= K) answer++;
        }
        
        return answer;
    }
}