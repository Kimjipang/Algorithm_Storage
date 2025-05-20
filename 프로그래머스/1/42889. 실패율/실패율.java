import java.util.*;

class Solution {
    private static HashMap<Integer, Integer> rate;
    private static HashMap<Integer, Double> rank;
    private static int[] answer;
    private static int challenger;
    
    private static int[] calculateRate(int N, int[] stages) {
        rate = new HashMap<>();
        rank = new HashMap<>();
        
        // 실패횟수 초기화
        for (int stage : stages) {
            rate.put(stage, rate.getOrDefault(stage, 0) + 1);
        }
        
        // 스테이지별 실패율 초기화
        for (int i = 1; i <= N; i++) {
            if (rate.containsKey(i)) {
                int loser = rate.get(i);
                rank.put(i, (double) loser / challenger);
                challenger -= loser;
            }
            else rank.put(i, 0.0);
        }
        
        return rank.entrySet().stream()
                            .sorted((o1, o2) -> 
                            o1.getValue().equals(o2.getValue()) 
                            ? Integer.compare(o1.getKey(), o2.getKey()) 
                            : Double.compare(o2.getValue(), o1.getValue()))
                            .mapToInt(HashMap.Entry::getKey)
                            .toArray();
        
    }
    
    public int[] solution(int N, int[] stages) {
        /*
        stages의 최대 길이 200,000이기 때문에 O(N^2) 미만으로 시간복잡도 잡아야 함.
        [풀이]
        해시맵으로 각 스테이지별 실패 횟수를 구함.
        스테이지에 머물러 있으면 그 스테이지에 대한 실패 횟수이기에 /8을 하면 실패율이 나옴.
        
        실패율이 담긴 map을 내림차순 정렬함.
        map을 순회하면서 key를 가져오고 그걸 배열에 넣음. 
        */
        challenger = stages.length;
        
        answer = calculateRate(N, stages);
        
        return answer;
    }
}