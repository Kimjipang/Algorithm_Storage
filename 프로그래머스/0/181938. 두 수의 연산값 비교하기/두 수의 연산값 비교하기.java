class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int num = 2 * a * b;
        
        String str1 = Integer.toString(a);
        String str2 = Integer.toString(b);
        
        answer = Integer.parseInt(str1 + str2);
        
        if (answer < num) {
            return num;
        }
        
        return answer;
    }
}