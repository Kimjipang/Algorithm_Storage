import java.util.*;

class Solution {
    private static int[] parent;
    
    private static int find(int x) {
        if (parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        int num1 = find(x);
        int num2 = find(y);
        
        if (num1 != num2) parent[num2] = num1;
    }
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        
        for (int i = 0; i < n; i++) parent[i] = i;
        
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        int answer = 0;
        int bridge = 0;
        
        for (int[] cost : costs) {
            int edge1 = cost[0];
            int edge2 = cost[1];
            int price = cost[2];
            
            if (bridge == n - 1) break;
            
            if (find(edge1) != find(edge2)) {
                union(edge1, edge2);
                answer += price;
                bridge++;
            }
        }
        
        return answer;
    }
}