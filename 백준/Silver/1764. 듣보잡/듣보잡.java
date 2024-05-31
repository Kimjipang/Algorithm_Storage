import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String allPeople = br.readLine();
        int unHeard = Integer.parseInt(allPeople.split(" ")[0]);
        int unSeen = Integer.parseInt(allPeople.split(" ")[1]);
        ArrayList<String> unHeardSeenPeople = new ArrayList<>();

        int unHeardSeen = 0;
        Map<String, Integer> bothPeople = new HashMap<>();

        for(int i = 0; i < unHeard; i++) {
            bothPeople.put(br.readLine(), 1);
        }
        for(int i = 0; i < unSeen; i++) {
            String unSeenPerson = br.readLine();
            if(bothPeople.containsKey(unSeenPerson)) {
                unHeardSeen++;
                unHeardSeenPeople.add(unSeenPerson);
            }
        }
        Collections.sort(unHeardSeenPeople);
        System.out.println(unHeardSeen);
        for(String st : unHeardSeenPeople) {
            System.out.println(st);
        }
    }
}
