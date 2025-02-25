class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int len = numLog.length;
        
        for (int i = 1; i < len; i++) {
            int num = numLog[i] - numLog[i - 1];
            
            if (num == 1) {
                answer += "w";
            }
            else if (num == -1) {
                answer += "s";
            }
            else if (num == -10) {
                answer += "a";
            }
            else {
                answer += "d";
            }
        }
        
        return answer;
    }
}