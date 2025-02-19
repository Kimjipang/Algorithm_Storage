class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        int len = str1.length();
        
        for (int i = 0; i < len; i++) {
            answer += str1.substring(i, i + 1) + str2.substring(i, i + 1);
        }
        return answer;
    }
}