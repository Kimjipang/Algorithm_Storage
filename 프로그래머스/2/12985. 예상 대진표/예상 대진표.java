
class Solution {
    public int solution(int n, int a, int b) {
        /*
        참가자 수가 최대 1024^2 정도
        
        [풀이]
        1. 한 라운드 당 절반씩 탈락하기 때문에 A와 B의 다음 번호는 (기존 번호 + 1 ) / 2
        2. (기존 번호 + 1) / 2가 같을 때까지 반복
        */
        int answer = 1;
        
        while ((a + 1) / 2 != (b + 1) / 2) {
            answer += 1;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }
}