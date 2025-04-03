import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        /*
        words의 길이는 최대 100 O(N^2) 가능
        
        1. set을 하나 만들고, words를 순회
        2-1. set에 값이 있으면 탈락자 반환
        2-2. 없으면 set에 집어 넣음.
        
        */
        int[] answer = {0, 0};
        
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        
        int len = words.length;
        int count = n;
        for (int i = 1; i < len; i++) { // words 순회
            String word = words[i];
            char last_alphabet = words[i - 1].charAt(words[i - 1].length() - 1);
            count++;
            
            // 전에 나온 적이 있는 단어이거나 끝말이 이어지지 않은 단어 체크
            if (set.contains(word) || last_alphabet != word.charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = count / n; 
                break;
            }
            set.add(word);
        }

        return answer;
    }
}