import java.util.*;

class Solution {
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static int N, answer;
    
    private static int dfs(int start) {
        visited[start] = true;
        int sum = 0;
        
        for (int next : adjList[start]) {
            if (!visited[next]) {
                int cnt = dfs(next);
                answer = Math.min(answer, Math.abs(N - cnt * 2));
                
                sum += cnt;
            }
        }
        return sum + 1;
    }
    
    public int solution(int n, int[][] wires) {
        /*
        n의 개수는 최대 100
        O(N^3)까지도 가능
        
        [풀이]
        1. 인접리스트 생성
        2. 그냥 하나씩 끊어보기..?
        */
        answer = n - 1;
        N = n;
        
        adjList = new ArrayList[n + 1];
        
        // 인접리스트 초기화
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            int idx = wire[0];
            int edge = wire[1];
            
            adjList[idx].add(edge);
            adjList[edge].add(idx);
        }
        
        visited = new boolean[n + 1];
        dfs(1);
               
        return answer;
    }
}