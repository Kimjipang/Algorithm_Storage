import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        /*
        phone_book 최대 길이 1,000,000이기에 O(N^2) 미만으로 해결
        
        [풀이]
        - 문자열 오름차순 정렬
        - 앞뒤로 접두사인지 확인
        */      
        Arrays.sort(phone_book); // O(NlogN)
        int num = phone_book.length;
        
        // System.out.println(Arrays.toString(phone_book));
        
        for (int i = 0; i < num - 1; i++) { // O(N)
            String cur = phone_book[i];
            String next = phone_book[i + 1];
            
            if (next.startsWith(cur)) return false;
        }

        return true;
    }
}