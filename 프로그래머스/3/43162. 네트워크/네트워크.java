import java.util.*;

class Solution {
    private static ArrayList<Integer>[] adjList;
    private static ArrayDeque<Integer> queue;
    private static boolean[] visited;
    
    private static void bfs(int i) {
        visited[i] = true;
        queue.addLast(i);
        
        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            
            for (int next : adjList[cur]) {
                if (!visited[next]) {
                    queue.addLast(next);
                    visited[next] = true;
                }
            }
        }
        
    }
    
    public int solution(int n, int[][] computers) {
        /*
        n, computers 최대 200
        
        [풀이]
        컴퓨터 간 연결 정보 저장할 리스트 초기화
        방문한 곳은 방문 처리
        1번(인덱스 0) 컴퓨터부터 n번 컴퓨터까지 
        */
        adjList = new ArrayList[n];
        visited = new boolean[n];
        queue = new ArrayDeque<>();
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    adjList[i].add(j);
                }
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