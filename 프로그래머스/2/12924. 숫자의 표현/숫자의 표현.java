class Solution {
    public int solution(int n) {
        int answer = 1;
        
        if (n > 2) {
            for (int i = 2; i < n; i++) {
                if (i == 2) {
                    if (n % 2 != 0) {
                        answer++;
                    }
                }
                else {
                    if (i % 2 != 0 && n % i == 0) {
                        answer++;
                    }
                }
        }
        }
        
        return answer;
    }
}