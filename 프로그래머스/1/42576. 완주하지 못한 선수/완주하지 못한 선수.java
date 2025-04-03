import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        /*
        participant의 길이는 최대 100,000이기에 O(N^2) 안됨.
        
        1. participant를 HashSet에 저장
        2. completion 순회하면 HashSet에 있는지 확인
        3. 동명이인 처리
        */
        
        Map<String, Integer> map = new HashMap<>();
        for (String str : completion) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        for (String str : participant) {
            if (map.getOrDefault(str, 0) == 0) {
                return str;
            }
            map.put(str, map.get(str) - 1);
        }
        
        return null;
    }
}