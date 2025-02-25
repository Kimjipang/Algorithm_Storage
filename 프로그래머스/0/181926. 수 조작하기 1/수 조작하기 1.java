class Solution {
    public int solution(int n, String control) {
        int len = control.length();
        
        for (int i = 0; i < len; i++) {
            if (control.substring(i, i + 1).equals("w")) {
                n += 1;
            }
            else if (control.substring(i, i + 1).equals("s")) {
                n -= 1;
            }
            else if (control.substring(i, i + 1).equals("a")) {
                n -= 10;
            }
            else {
                n += 10;
            }
        }
        
        return n;
    }
}