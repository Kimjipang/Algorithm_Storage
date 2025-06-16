import java.util.*;

class Solution {
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static ArrayDeque<Integer> queue;
    private static int N;
    
    private static void init(int[][] computers) {
        visited = new boolean[N];
        queue = new ArrayDeque<>();
        adjList = new ArrayList[N];
        
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (i != j && computers[i][j] == 1) {
                    adjList[i].add(j);
                }
            }
        }
    }
    
    private static void bfs(int start) {
        queue.addLast(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            
            for (int next : adjList[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.addLast(next);
                }
            }
        }
    }
    public int solution(int n, int[][] computers) {
        /*
        n이 최대 200이기에 computers의 최대 길이 순회 시 200 X 200
        
        [풀이]
        인접 리스트 초기화 하고 bfs 돌리기
        
        */
        N = n;
        init(computers);
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
}