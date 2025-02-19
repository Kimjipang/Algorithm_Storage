class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int len = my_string.length() - overwrite_string.length() - s;
        
        for (int i = 0; i < my_string.length(); i++) {
            if (i < s) {
                answer += my_string.substring(i, i + 1);
            }
        }
        
        answer += overwrite_string;
        
        if (len != 0) {
            for (int i = my_string.length() - len; i < my_string.length(); i++) {
                answer += my_string.substring(i, i + 1);
            }
        }
        return answer;
    }
}