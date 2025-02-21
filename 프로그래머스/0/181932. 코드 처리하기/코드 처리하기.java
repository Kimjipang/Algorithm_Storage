class Solution {
    public String solution(String code) {
        String answer = "";
        int len = code.length();
        int mode = 0;
        
        for (int i = 0; i < len; i++) {
            if (mode == 0 && code.substring(i, i + 1).equals("1")) {
                mode = 1;
            }
            
            else if (mode == 0 && !code.substring(i, i + 1).equals("1")) {
                if (i % 2 == 0) {
                    answer += code.substring(i, i + 1);
                }
            }
            
            else if (mode == 1 && code.substring(i, i + 1).equals("1")) {
                mode = 0;
            }
            
            else if (mode == 1 && !code.substring(i, i + 1).equals("1")) {
                if (i % 2 != 0) {
                    answer += code.substring(i, i + 1);
                }
            }
        }
        
        if (answer.length() == 0) {
            return "EMPTY";
        }
        
        return answer;
    }
}