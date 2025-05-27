import java.util.*;

class Solution {
    private static ArrayDeque<String> cardDeque1;
    private static ArrayDeque<String> cardDeque2;
    private static ArrayDeque<String> goalDeque;
    
    private static String calculate() {
        while (!goalDeque.isEmpty()) { // N 최대 20
            
            String card1 = cardDeque1.peekFirst();
            String card2 = cardDeque2.peekFirst();
            String word = goalDeque.peekFirst();
            
            if (!cardDeque1.isEmpty() && card1.equals(word)) {
                cardDeque1.pollFirst();
                goalDeque.pollFirst();
            }
            else if (!cardDeque2.isEmpty() && card2.equals(word)) {
                cardDeque2.pollFirst();
                goalDeque.pollFirst();
            }
            
            else break;
        }
        
        return goalDeque.size() == 0 ? "Yes" : "No";
    }
    
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        /*
        cards1, cards2 두 배열 모두 최대 길이가 10
        시간 복잡도면에서 여유로움 
        
        [풀이]
        1. goal 배열에 앞에서부터 하나씩 cards1과 cards2 중 있는지 확인하고 있으면 뺌.
        2. 안 빼지면 "No"
        */
        String answer = "";
        
        cardDeque1 = new ArrayDeque<>(Arrays.asList(cards1)); // N 최대 10
        cardDeque2 = new ArrayDeque<>(Arrays.asList(cards2)); // N 최대 10
        goalDeque = new ArrayDeque<>(Arrays.asList(goal)); // N 최대 20
        
        answer = calculate();
        
        return answer;
    }
}