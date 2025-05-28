import java.util.*;

class Solution {
    private static HashMap<String, String> userInfo;
    
    private static void initHashMap(String[] record) {
        userInfo = new HashMap<>();
        
        for (String log : record) {
            String[] arr = log.split(" ");
            String action = arr[0];
            
            if (action.equals("Enter") || action.equals("Change")) {
                String id = arr[1];
                String name = arr[2];
                userInfo.put(id, name);
            }
        }
    }
    
    private static String[] createLog(String[] record) {
        ArrayList<String> result = new ArrayList<>();
        
        for (String log : record) {
            String[] arr = log.split(" ");
            String action = arr[0];
            String id = arr[1];
            
            if (action.equals("Enter")) {
                String name = userInfo.get(id);
                result.add(name + "님이 들어왔습니다.");
            }
            else if (action.equals("Leave")) {
                String name = userInfo.get(id);
                result.add(name + "님이 나갔습니다.");
            }
        }
        
        return result.stream()
                    .toArray(String[]::new);
    }
    
    public String[] solution(String[] record) {
        /*
        record의 최대 길이 100,000 O(N^2) 불가
        
        [풀이]
        1. record를 순회하면서 uid를 key로, 이름을 value로 하는 HashMap을 초기화
        2. 다시 순회를 하며 Enter면 ~님이 들어왔습니다. Leave면 나갔습니다 출력
        */
        initHashMap(record);
        
        String[] answer = createLog(record);
        
        return answer;
    }
}