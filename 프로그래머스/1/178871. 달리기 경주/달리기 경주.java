import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        
        int callings_len = callings.length;
        int players_len = players.length;
        
        for (int i = 0; i < players_len; i++) {
            map.put(players[i], i);
        }
        
        for (int j = 0; j < callings_len; j++) {
            int grade = map.get(callings[j]);
            
            String tmp = players[grade-1];
            players[grade - 1] = players[grade];
            players[grade] = tmp;
            
            map.put(players[grade - 1], grade - 1);
            map.put(players[grade], grade);
        }
        return players;
    }
}