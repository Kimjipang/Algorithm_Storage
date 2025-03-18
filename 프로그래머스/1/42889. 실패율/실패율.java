import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        /*
        실패율 -> 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        실패율이 높은 스테이지 순서대로 반환, 실패율 같은 스테이지는 오름차순
        
        stages의 길이가 200,000이므로 O(N^2)로 하면 절대 안 됨.
        */
        
        // 스테이지별 도전자 수 계산
        int[] challengers = new int[N + 2];
        
        for (int stage : stages) {
            challengers[stage] += 1;
        }
        
        // 실패율 계산
        Map<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        
        for (int i = 1; i <= N; i++) {
            if (challengers[i] == 0) {
                fails.put(i, 0.0);
            }
            else {
                fails.put(i, challengers[i] / total);
                total -= challengers[i];
            }
        }
        
        return fails.entrySet().stream()
                                .sorted((o1, o2) ->
                                       o1.getValue().equals(o2.getValue()) 
                                        ? Integer.compare(o1.getKey(), o2.getKey())
                                       : Double.compare(o2.getValue(), o1.getValue()))
                                .mapToInt(HashMap.Entry::getKey)
                                .toArray();
    }
}