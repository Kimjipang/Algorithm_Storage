import java.util.*;
import java.util.stream.*;

class Solution {
    private static HashMap<String, Integer> genreMap;
    private static HashMap<String, ArrayList<int[]>> playMap;
    
    private static int[] calculate(String[] genres, int[] plays) {
        genreMap = new HashMap<>();
        playMap = new HashMap<>();
        
        int n = genres.length;
        
        for (int i = 0; i < n; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, 0);
                playMap.put(genre, new ArrayList<>());
            }
            
            genreMap.put(genre, genreMap.get(genre) + play);
            playMap.get(genre).add(new int[] {i, play});
            
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 장르별 재생수 내림차순 정렬
        Stream<Map.Entry<String, Integer>> sortedGenres = genreMap.entrySet()
                                    .stream()
                                    .sorted((o1, o2)
                                    -> Integer.compare(o2.getValue(), o1.getValue()));
        
        sortedGenres.forEach(entry -> {
            Stream<int[]> sortedSongs = playMap.get(entry.getKey())
                            .stream()
                            .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                            .limit(2);
            
            sortedSongs.forEach(song -> answer.add(song[0]));
        });
        
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = calculate(genres, plays);
        return answer;
    }
}