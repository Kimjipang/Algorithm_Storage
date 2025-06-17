import java.util.*;

class Solution {
    private static ArrayList<Node>[] adjList;
    private static int[] dist;
    private static int n;
    
    private static class Node {
        int dest;
        int cost;
        
        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
    private static void init(int[][] road) {
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        adjList = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] arr : road) {
            int from = arr[0];
            int to = arr[1];
            int cost = arr[2];
            
            adjList[from].add(new Node(to, cost));
            adjList[to].add(new Node(from, cost));
        }
    }
    
    private static void calculate() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(1, 0));
        
        dist[1] = 0;
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (dist[cur.dest] < cur.cost) continue;
            
            for (Node next : adjList[cur.dest]) {
                if (dist[next.dest] > cur.cost + next.cost) {
                    dist[next.dest] = cur.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
    }
    public int solution(int N, int[][] road, int K) {
        /*
        양방향 연결
        다익스트라 알고리즘 활용
        
        [풀이]
        - 시작 노드의 이전 노드를 자기 자신으로 기록 + 자기 자신까지 이동하는 거리를 무한대로 둠.
        - 1번 마을부터 순회(i)하면서 i번 마을부터 각 마을(인접한 마을)까지의 거리를 계산 기존보다 거리가 작으면 그 거리로 초기화
        - 마지막에 k가 3이하인 것들의 개수 반환
        */
        n = N;
        init(road);
        calculate();
        
        int answer = 0;
        
        for (int num : dist) {
            if (num <= K) answer++;
        }
        
        
        return answer;
    }
}