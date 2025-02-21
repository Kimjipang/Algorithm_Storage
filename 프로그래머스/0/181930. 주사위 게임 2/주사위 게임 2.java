class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        
        if (a != b && b != a && a != c && b != c) {
            return a + b + c;
        }
        else if ((a == b && b != c) || (a == c && b != c) || (b == c && a != b)) {
            return (a + b + c) * (a * a + b * b + c * c);
        }
        
        return (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
        
    }
}