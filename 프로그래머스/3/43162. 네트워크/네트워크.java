class Solution {
    private static boolean[] visited;
    private static int[][] computer;
    
    private static void dfs(int start) {
        visited[start] = true;
        
        int n = computer[start].length;
        
        for (int i = 0; i < n; i++) {
            if (computer[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        computer = computers;
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
}