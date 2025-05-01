import java.util.*;

class Solution {
    private static ArrayList<Integer>[] adjList;
    private static ArrayDeque<Integer> queue;
    private static boolean[] visited;
    
    private static void bfs(int num) {
        queue = new ArrayDeque<>();
        
        queue.addLast(num);
        visited[num] = true;
        
        while (!queue.isEmpty()) {
            int idx = queue.pollFirst();
            int size = adjList[idx].size();
            
            if (size == 0) continue;
            
            for (int i = 0; i < size; i++) {
                int node = adjList[idx].get(i);
                if (!visited[node]) {
                    queue.addLast(node);
                    visited[node] = true;
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        adjList = new ArrayList[n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) 
                adjList[i].add(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
}