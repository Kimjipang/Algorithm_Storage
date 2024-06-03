import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> inCars = new HashMap<>();
        for(int i = 0; i < n; i++){
            inCars.put(br.readLine(), i);
        }

        int[] outCars = new int[n]; 
        for(int i = 0; i < n; i++){
            outCars[i] = inCars.get(br.readLine());
        }

        int count = 0;
        for(int current = 0; current < n; current++){
            for(int next = current + 1; next < n; next++){
                if(outCars[current] > outCars[next]){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}