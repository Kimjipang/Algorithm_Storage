import java.util.*;

class Solution {
    private static int[] parent;
    
    private static int find(int x) {
        if (parent[x] == x) 
            return x;
        
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        parent = new int[n];
        
        int answer = 0;
        int edge = 0;
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int[] cost : costs) {
            if (edge == n - 1) {
                break;
            }
            
            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                
                answer += cost[2];
                edge++;
            }
        }
        return answer;
    }
}