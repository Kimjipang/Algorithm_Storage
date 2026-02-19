import java.util.*;

class Solution {
    public int solution(int[] elements) {
        /*
        배열의 길이만큼 반복을 해야함.
            - 최대 1,000번
        가지 수를 구할 집합을 초기화해야 함.
        
        */
        int len = elements.length;
        int[] newElements = new int[len * 2];
        
        for (int i = 0; i < len; i++) {
            newElements[i] = elements[i];
            newElements[i + len] = elements[i];
        }
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                set.add(Arrays.stream(newElements, j, j + i).sum());
            }
        }
        
        int answer = set.size();
        
        return answer;
    }
}