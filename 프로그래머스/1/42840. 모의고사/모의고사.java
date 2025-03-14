import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        /*
        answers가 주어지고 1,2,3번 수포자 중에서 누가 제일 많이 답을 맞췄는지 계산하는 문제
        1번 수포자 -> 1, 2, 3, 4, 5 반복
        2번 수포자 -> 2, 1, 2, 3, 2, 4, 2, 5 반복
        3번 수포자 -> 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 반복
        
        총 3번 순회를 해야 하는데, 3명의 수포자를 순회하면서 정답이랑 비교하고 정답 개수 반환
        */
        int[] result = new int[3];
        int len = answers.length;
        
        int[][] people = {{1, 2, 3, 4, 5},
                          {2, 1, 2, 3, 2, 4, 2, 5},
                         {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        
        for (int i = 0; i < 3; i++) {
            int num = people[i].length;
            int count = 0;
            
            for (int j = 0; j < len; j++) {
                if (answers[j] == people[i][j % num]) {
                    count++;
                }
            }
            result[i] = count;
        }
        
        return countBestScorer(result).stream()
                                    .mapToInt(Integer::intValue)
                                    .toArray();
    }
    
    private static List<Integer> countBestScorer(int[] result) {
        // 3개 중에서 제일 높은 숫자를 찾은 후에 다시 처음부터 비교해서 카운트를 세
        List<Integer> list = new ArrayList<>();
        
        int num = Arrays.stream(result).max().orElse(-1);
        
        for (int i = 0; i < 3; i++) {
            if (num == result[i]) {
                list.add(i + 1);
            }
        }
        
        return list;
    }
}