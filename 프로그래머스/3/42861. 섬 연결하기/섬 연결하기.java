import java.util.*;

class Solution {
    private static int[] parent;
    
    private static int find(int x) {
        if (parent[x] != x) return parent[x] = find(parent[x]);
        
        return x;
    }
    
    private static void union(int x, int y) {
        int num1 = find(x);
        int num2 = find(y);
        
        parent[num2] = num1;
    }
    public int solution(int n, int[][] costs) {
        /*
        n은 최대 100
        costs의 최대 길이 4950
        최소 비용으로 섬을 연결해야 함.
        모든 섬의 부모가 결국 같게 해야 함.
        
        
        [풀이]
        거리 기준으로 정렬 후 부모가 같지 않으면 union
        
        */
        parent = new int[n];
        
        for (int i = 0; i < n; i++) parent[i] = i;
        
        int answer = 0;
        int edges = 0;
        
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        for (int[] cost : costs) {
            int edge1 = cost[0];
            int edge2 = cost[1];
            int price = cost[2];
            
            if (edges == n - 1) return answer;
            
            if (find(edge1) != find(edge2)) {
                union(edge1, edge2);
                answer += price;
                edges++;
            }
            
        }
        
        return answer;
    }
}