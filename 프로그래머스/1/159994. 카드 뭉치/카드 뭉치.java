import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        /*
        cards1, cards2의 최대 길이는 10
        
        1. cards1, cards2를 큐에 저장
        2. goal을 순회하면서 cards1 or cards2 맨 앞 요소에 원하는 것이 있으면 goal에서 제거
        2-1. 없으면 바로 "No" 반환
        2-2. 있으면 순회 이후 "Yes" 반환
        */ 
        ArrayDeque<String> card1 = new ArrayDeque<>(Arrays.asList(cards1)); // cards1 큐로 초기화
        ArrayDeque<String> card2 = new ArrayDeque<>(Arrays.asList(cards2)); // cards2 큐로 초기화
        
        for (String str : goal) {
            String card1_word = card1.peekFirst();
            String card2_word = card2.peekFirst();
            if (!card1.isEmpty() && card1_word.equals(str)) {
                card1.pollFirst();
            }
            else if (!card2.isEmpty() && card2_word.equals(str)) {
                card2.pollFirst();
            }
            else return "No";
        }
        
        return "Yes";
    }
}