import java.util.*;

class Solution {
    private static int[] personA = {1, 2, 3, 4, 5};
    private static int[] personB = {2, 1, 2, 3, 2, 4, 2, 5};
    private static int[] personC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    private static int calculateScore(int[] who, int[] answers) {
        int n = answers.length;
        int len = who.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) { 
            int answer = answers[i];
            
            if (who[i % len] == answer) count++;
        }
        return count;
    }
    public int[] solution(int[] answers) {
        /*
        [풀이]
        각 수포자가 찍는 방식을 담은 배열 초기화
        answers 순회하면서 몇 개 맞았는지 체크
        점수 같으면 오름차순 정렬
        
        배열의 길이는 최대 10,000 O(N^2)으로 해결하면 안됨.
        */
        ArrayList<Integer> result = new ArrayList<>();
        
        int a = calculateScore(personA, answers); // n
        int b = calculateScore(personB, answers); // n
        int c = calculateScore(personC, answers); // n
        
        int[] scores = {a, b, c};
        
        int max = Arrays.stream(scores) // n
                        .max()
                        .getAsInt();
        
        for (int i = 0; i < 3; i++) { // 1
            if (max == scores[i]) result.add(i + 1);
        }
                
        return result.stream() // n
                    .mapToInt(Integer::intValue)
                    .toArray();
        
    }
}