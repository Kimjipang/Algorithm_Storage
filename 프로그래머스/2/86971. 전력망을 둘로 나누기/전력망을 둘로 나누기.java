import java.util.*;

class Solution {
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayDeque<Integer> queue;
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
        int count = 1;
        queue.addLast(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            
            for (int next : adjList[cur]) {
                if (!visited[next]) {
                    queue.addLast(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        return count;
        
    }
    public int solution(int n, int[][] wires) {
        N = n;
        int answer = n;
        init(wires);
        
        for (int[] wire : wires) {
            int edge1 = wire[0];
            int edge2 = wire[1];
            
            adjList[edge1].remove(Integer.valueOf(edge2));
            adjList[edge2].remove(Integer.valueOf(edge1));
            
            int num = bfs(edge1);
            int num2 = n - num;
            answer = Math.min(answer, Math.abs(num - num2));
            
            adjList[edge1].add(edge2);
            adjList[edge2].add(edge1);
        }
        
        return answer;
    }
}