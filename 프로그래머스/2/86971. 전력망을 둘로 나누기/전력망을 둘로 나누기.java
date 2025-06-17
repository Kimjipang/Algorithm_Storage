import java.util.*;

class Solution {
    private static ArrayList<Integer>[] adjList;
    private static ArrayDeque<Integer> queue;
    private static boolean[] visited;
    private static int N;
    
    private static void init(int[][] wires) {
        
        adjList = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            int edge1 = wire[0];
            int edge2 = wire[1];
            
            adjList[edge1].add(edge2);
            adjList[edge2].add(edge1);
        }
        
    }
    
    private static int bfs(int start) {
        queue = new ArrayDeque<>();
        visited = new boolean[N + 1];
        
        queue.addLast(start);
        visited[start] = true;
        int count = 1;
        
        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            
            for (int num : adjList[cur]) {
                if (!visited[num]) {
                    queue.addLast(num);
                    visited[num] = true;
                    count++;
                }
            }
        }
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        /*
        n 최대 100, wires 최대 길이 99
        
        [풀이]
        - 인접리스트 초기화
        - dfs로 인접 리스트 순회하면서 방문할 때마다 카운트
        - 임의로 1개씩 끊어서 전선 개수의 차이를 계산
        - 최소차이 반환
        */
        N = n;
        init(wires);
        int answer = n;
        
        for (int i = 0; i < n - 1; i++) {
            int u = wires[i][0];
            int v = wires[i][1];
            
            adjList[u].remove(Integer.valueOf(v));
            adjList[v].remove(Integer.valueOf(u));
            
            int cnt1 = bfs(1);
            int cnt2 = N - cnt1;
            
            answer = Math.min(answer, Math.abs(cnt1 - cnt2));
            
            adjList[u].add(v);
            adjList[v].add(u);
        }
        
        return answer;
    }
}