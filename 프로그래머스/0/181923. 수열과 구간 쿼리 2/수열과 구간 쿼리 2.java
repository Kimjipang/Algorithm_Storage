class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int len = queries.length;
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            int l = queries[i][0];
            int num = queries[i][1];
            int k = queries[i][2];
            int min = 1000001;
            
            for (int j = l; j <= num; j++) {
                if (arr[j] > k) {
                    if (arr[j] < min) {
                        min = arr[j];
                    }
                }
            }
            
            if (min == 1000001) answer[i] = -1;
            else answer[i] = min;
            
        }
        return answer;
    }
}