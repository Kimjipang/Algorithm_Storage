import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        /*
        participant의 최대 길이는 100,000임. 시간 복잡도 O(N^2) 미만으로 해결 필수
        
        [풀이]
        1. participant의 요소를 key로, 요소의 개수를 value로 하는 해시맵 초기화
        2. completion를 순회하며 key가 존재하면 value를 -1
        3. completion을 순회하며 value가 1이 아닌 것을 반환
        */
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String str : participant) map.put(str, map.getOrDefault(str, 0) + 1);
        for (String str : completion) map.put(str, map.get(str) - 1);
        
        for (String str : participant) {
            if (map.get(str) != 0) return str;
        }
        
        return "";
    }
}