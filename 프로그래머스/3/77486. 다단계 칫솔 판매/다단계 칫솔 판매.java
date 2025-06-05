import java.util.*;

class Solution {
    private static HashMap<String, String> referralMap;
    private static HashMap<String, Integer> profit;
    
    private static void initHashMap(String [] enroll, String [] referral) {
        referralMap = new HashMap<>();
        profit = new HashMap<>();
        
        int n = enroll.length;
        
        for (int i = 0; i < n; i++) {
            String enroller = enroll[i];
            String referraler = referral[i];
            
            if (!referralMap.containsKey(enroller)) {
                referralMap.put(enroller, referraler);
                profit.put(enroller, 0);
            }
        }
    }
    
    private static void calculateProfit(String[] seller, int[] amount) {
        int n = seller.length;
        
        for (int i = 0; i < n; i++) {
            String person = seller[i]; // seller가 young일 때 
            int money = amount[i] * 100;
            
            while (money > 0 && !person.equals("-")) {    
                profit.put(person, profit.get(person) + money - money / 10);
                person = referralMap.get(person);
                money = money / 10;
            }
        }
        
        
        
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        /*
        referral, enroll 최대 길이 10,000이고 길이가 같음
        seller의 최대 길이 100,000
        amount의 최대 길이 100,000
        
        [풀이]
        자신의 추천인이 누군지 hashmap으로 초기화 key -> enroll, value -> referral
        각자 수익금이 얼마인지 hashmap으로 초기화 key -> enroll, value -> 수익금
        
        • 수익금 계산
        - seller 순회하면서 value가 -가 아니면 value에게 10% 떼어주고, key값을 value로 하는 key의 value가
          또 -인지 아닌지를 반복해서 확인 while문 필요
        - "-"이면 10% 떼어주기만 하고 끝
        
        */
        int n = enroll.length;
        int[] answer = new int[n];
        
        initHashMap(enroll, referral);
        calculateProfit(seller, amount);
        
        for (int i = 0; i < n; i++) {
            answer[i] = profit.get(enroll[i]);
        }
        
        return answer;
    }
}