import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        /*
        [풀이]
        이중 반복문으로 모든 경우의 수 계산
        배열 최대 길이 100 이기 때문에 최대 연산 수 -> (100 * 99) / 2임
        */
        ArrayList<Integer> answer = new ArrayList<>();
        
        int n = numbers.length; // 연산 횟수 1
        
        for (int i = 0; i < n - 1; i++) { // 연산 횟수 n - 1;
            for (int j = i + 1; j < n; j++) { // 연산 횟수 n - 1;
                answer.add(numbers[i] + numbers[j]); // 연산 횟수 1
            }
        }
        
        int[] result = answer.stream()
                            .distinct() // 연산 횟수 n
                            .sorted() // 연산 횟수 n*log(n)
                            .mapToInt(Integer::intValue) // 연산횟수 n
                            .toArray(); // 연산횟수 n
        
        return result;
    }
}