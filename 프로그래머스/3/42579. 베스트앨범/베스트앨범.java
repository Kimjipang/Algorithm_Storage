import java.util.*;
import java.util.stream.*;

class Solution {
    private static HashMap<String, Integer> genreMap;
    private static HashMap<String, ArrayList<int[]>> playMap;
    
    private static void initHashMap(String[] genres, int[] plays) {
        int n = genres.length;
        
        genreMap = new HashMap<>();
        playMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            if (!playMap.containsKey(genre)) {
                playMap.put(genre, new ArrayList<>());
            }
            
            genreMap.put(genre, genreMap.getOrDefault(genre, 0) + play);
            playMap.get(genre).add(new int[] {i, play});
        }
    }
    
    private static int[] generateBestAlbum() {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Stream<Map.Entry<String, Integer>> sortedGenre = genreMap.entrySet()
                                .stream()
                                .sorted((o1, o2) ->
                                    Integer.compare(o2.getValue(), o1.getValue()));
        
        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs =playMap.get(entry.getKey())
                                        .stream()
                                        .sorted((o1, o2) -> 
                                            Integer.compare(o2[1], o1[1]))
                                        .limit(2);
            sortedSongs.forEach(song -> answer.add(song[0]));
        });
           
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }

    public int[] solution(String[] genres, int[] plays) {
        /*
        genres와 plays의 최대 길이는 10,000이기에 O(N^2) 미만의 시간복잡도로 해결
        
        [풀이]
        1. genres 별 총 재생 횟수를 저장하는 hashmap초기화 후 정렬
        2. 곡별 재생 횟수를 저장하는 hashmap 초기화
        3. 장르 별로 최대 2개씩 베스트 앨범에 추가
        */
        initHashMap(genres, plays);
        
        int[] answer = generateBestAlbum();
        
        return answer;
    }
}