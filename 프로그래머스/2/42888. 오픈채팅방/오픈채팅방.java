import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        /*
        record의 길이가 최대 100,000이기 때문에 O(N^2)는 안됨.
        
        [풀이]
        1. 유저 아이디가 key이고 닉네임이 value인 map을 생성
        2. 
        */
        int n = record.length;
        List<String> list = new ArrayList<>();
        
        Map<String, String> member = new HashMap<>();
        
        // 멤버 정보 해시맵에 저장
        for (String str : record) {
            String[] log = str.split(" ");
            if (!log[0].equals("Leave")) {
                member.put(log[1], log[2]);
            }
        }
        
        for (int i = 0; i < n; i++) {
            String[] log = record[i].split(" ");
            if (log[0].equals("Enter")) {
                list.add(member.get(log[1]) + "님이 들어왔습니다.");
            }
            else if (log[0].equals("Leave")) {
                list.add(member.get(log[1]) + "님이 나갔습니다.");
            }
        }
        
        String[] answer = list.stream()
                                .toArray(String[]::new);
        
        return answer;
    }
}