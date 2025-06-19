
class Solution {
    private static int[][] Dungeons;
    private static boolean[] visited;
    private static int n, answer;
    
    private static void backTrack(int k, int cnt) {
        for (int i = 0; i < n; i++) {
            if (!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true;
                backTrack(k - Dungeons[i][1], cnt + 1);
                answer = Math.max(answer, cnt + 1);
                visited[i] = false;
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        /*
        현재 피로도 k, 각 던전별 '최소 필요 피로도', '소모 피로도'
        
        k는 최대 5,000, 던전 개수는 최대 8 X 2
        */
        Dungeons = dungeons;
        n = dungeons.length;
        visited = new boolean[n];
        answer = 0;
        backTrack(k, 0);
        return answer;
    }
}