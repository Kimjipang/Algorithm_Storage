import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        /*
        판매원은 수익금을 90%만 먹고 10%는 추천인에게 줌.
        때문에 모든 판매원은 본인의 수익금 + 자신이 추천해준 사람의 수익금 10%도 먹음.
        하지만 1원 단위에서 절사
        
        [풀이]
        1. 추천받은 사람과 추천인의 관계를 나타내는 HashMap 생성 <추천받은 사람, 추천인>
        2. seller가 몇 개 팔았는지를 나타내는 HashMap 생성 <seller, amount>
        3. 직원들이 총 얼마를 벌었는지 나타내는 HashMap 생성 <enroll, 수익금>
        4. seller와 amount를 순회하며 추천인이 있는지를 확인
        4-1. 추천인이 있으면 10% 떼고, 추천인의 추천인이 있는지 확인을 반복
        
        */
        HashMap<String, String> recommendation = new HashMap<>();
        HashMap<String, Integer> total = new HashMap<>();
        
        int n = enroll.length;
        int s = seller.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) { // <추천받은 사람, 추천인> HashMap 초기화
            recommendation.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i < s; i++) {
            String curSeller = seller[i];
            int money = amount[i] * 100;
            
            while (money > 0 && !curSeller.equals("-")) {
                total.put(curSeller, total.getOrDefault(curSeller, 0) + money - money / 10);
                
                curSeller = recommendation.get(curSeller);
                money /= 10;
            }
        }
        
        for (int i = 0; i < n; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
}