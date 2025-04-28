import java.util.*;

class Solution {
    private static int[] parent;
    
    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        int num1 = find(x);
        int num2 = find(y);
        
        parent[num2] = num1;
    }
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        int answer = 0;
        int edge = 0;
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int[] cost : costs) {
            int node1 = cost[0];
            int node2 = cost[1];
            
            if (edge == n - 1) break;
            
            if (find(node1) != find(node2)) {
                union(node1, node2);
                
                edge++;
                answer = answer + cost[2];
            }
        }
        
        return answer;
    }
}