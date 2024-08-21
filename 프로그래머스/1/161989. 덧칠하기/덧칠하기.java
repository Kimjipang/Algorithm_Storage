class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        answer = calculatePaint(section, n , m);
        
        return answer;
    }
    private static int calculatePaint(int[] section, int n, int m) {
        int len = section.length;
        int count = 1;
        int start = section[0];
        int end = section[0] + m - 1;
        
        if (section[0] + m - 1 >= section[len - 1]) {
            return 1;
        }
        else {
            for (int i = 0; i < len; i++) {
                if (section[i] >= start && section[i] <= end) {
                    continue;
                }
                else {
                    start = section[i];
                    end = section[i] + m - 1;
                    count++;
                }
            }
        }
        return count;
    }
}