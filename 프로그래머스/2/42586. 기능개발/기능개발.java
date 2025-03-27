import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        /*
        두 배열의 길이가 모두 최대 100이라 O(N^3)까지도 가능
        
        1. 각 기능 별로 얼마나 걸리는지를 계산해서 큐에 저장
        2. 맨 앞 요소부터 꺼내면서 뒤에 요소보다 크면 모두 한 번에 반환
        2-1. 뒤에 요소보다 작으면 뒤에 요소 전까지만 반환
        */
        int n = progresses.length;
        int[] answer = new int[n];
        List<Integer> deploy = new ArrayList<>();
        
        // 기능 구현 소요 시간 계산
        for (int i = 0; i < n; i++) {
            int percent = progresses[i];
            int speed = speeds[i];
            int count = 0;
            while (percent < 100) {
                percent += speed;
                count++;
            }
            answer[i] = count;
        }
        
        // 배포 개수 계산
        int num = answer[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (num < answer[i]) {
                deploy.add(count);
                num = answer[i];
                count = 1;
            }
            else count++;
            
        }
        deploy.add(count);
        
        return deploy.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
    }
}