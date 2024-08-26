class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        int half_len = len / 2;
        answer = (len % 2 == 0) ? s.substring(half_len - 1, half_len + 1) : s.substring(half_len, half_len + 1);
        return answer;
    }
}