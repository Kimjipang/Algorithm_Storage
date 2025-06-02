import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        /*
        id_list의 최대 길이 1,000
        report의 최대 길이 200,000

        1. 신고 당한 횟수를 담는 해시맵(respondent) 선언
        2. 누굴 신고했는지를 담는 해시맵(reporter) 선언 - 한 사람이 같은 사람을 중복으로 신고하는 것 카운                                                  트 X하기 위함
        2-1. 신고자가 이미 이전에 신고를 했으면 신고 횟수 카운트 X
        2-2. 처음 신고하면 respondent와 reporter에 저장
        3. report 순회하면서 신고자가 신고한 피신고자가 제재 대상인지 확인 
        */
        HashMap<String, HashSet<String>> reportedUser = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        int n = id_list.length;
        int[] answer = new int[n];

        for (String str : report) {
            String[] arr = str.split(" ");
            String reporterId = arr[0];
            String reportedId = arr[1];
            if (!reportedUser.containsKey(reportedId)) {
                reportedUser.put(reportedId, new HashSet<>());
            }
            reportedUser.get(reportedId).add(reporterId);
        }

        for (Map.Entry<String, HashSet<String>> entry : reportedUser.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String id : entry.getValue()) {
                    count.put(id, count.getOrDefault(id, 0) + 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            answer[i] = count.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}