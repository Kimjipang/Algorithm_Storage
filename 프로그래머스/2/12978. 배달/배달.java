import java.util.*;

class Solution {
    static ArrayList<ArrayList<Node>> list;
    static int cnt;
    
    class Node {
        int x, y, z;
        
        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int len = road.length;
        
        cnt = 1;
        
        list = new ArrayList<>();
        int[] visited = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < len; i++) {
            list.get(road[i][0]).add(new Node(road[i][0], road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][1], road[i][0], road[i][2]));
        }
        
        bfs(N, K, visited);
        
        answer = cnt;
        
        return answer;
    }
    private static void bfs(int N, int K, int[] visited) {
        Queue<Node> queue = new LinkedList<>();
        
        for (int i = 2; i < visited.length; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        
        queue.addAll(list.get(1));
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if(!(visited[node.y] <= visited[node.x] + node.z)) {
                visited[node.y] = visited[node.x] + node.z;
                queue.addAll(list.get(node.y));
            }
        }
        
        for (int i = 2; i < N + 1; i++) {
            if (visited[i] <= K) {
                cnt++;
            }
        }
    }
}