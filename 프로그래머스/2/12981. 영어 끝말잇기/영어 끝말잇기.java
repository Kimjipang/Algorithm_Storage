import java.util.*;

class Solution {
    private static HashSet<String> used;
    
    private static boolean isAvailable(String preWord, String curWord) {
        boolean isSameChar = preWord.charAt(preWord.length() - 1) == curWord.charAt(0);
        
        return isSameChar && !used.contains(curWord);
        
    }
    private static int[] findDropOut(String[] words, int n) {
        int num = words.length;
        int round = 1;
        used.add(words[0]);
        
        for (int i = 1; i < num; i++) {
            String preWord = words[i - 1];
            String curWord = words[i];
            
            if (i % n == 0) round++;
            
            if (!isAvailable(preWord, curWord)) {
                return new int[] {i % n + 1, round};
            }
            
            used.add(curWord);
            
        }
        return new int[] {0, 0};
    }
    
    public int[] solution(int n, String[] words) {
        /*
        n은 최대 10
        words의 최대 길이 100
        
        [풀이]
        - 이미 나온 단어 거르기 위한 set 초기화
        - 이전 단어의 끝과 다음 단어의 시작이 같은지 + set에 없는지 확인
            - true면 쭉 순회, false면 몇 번째 사람이 몇 번째 사이클에 탈락인지 반환
        */
        used = new HashSet<>();
        
        int[] answer = findDropOut(words, n);
        
        return answer;
    }
}