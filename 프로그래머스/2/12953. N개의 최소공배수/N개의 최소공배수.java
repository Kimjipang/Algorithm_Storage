class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int len = arr.length;
        
        if (len == 1) return arr[0];
        
        int g = gcd(arr[0], arr[1]);
        answer = arr[0] * arr[1] / g;
        
        if (len > 2) {
            for (int i = 2; i < len; i++) {
                g = gcd(arr[i], answer);
                answer = arr[i] * answer / g;
            }
        }
        return answer;
    }
    
    private static int gcd(int n, int m) {
        int r = 0;
        r = n % m;
        
        if (r == 0) {
            return m;
        }
        return gcd(m, r);
    }
}