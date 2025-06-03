class Solution {
    public int solution(int n, int a, int b) {
        /*
        게임 참가자 수 N, 참가자 번호 A, 경쟁자 번호 B
        짝수라서 부전승 X
        
        1, 2 / 3, 4 / 5, 6
        [풀이]
        
        */
        int answer = 1;
        
        while ((a + 1) / 2 != (b + 1) / 2) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            
            answer++;
        }

        return answer;
    }
}