import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String[] inputCards = br.readLine().split(" ");
        int[] cards = new int[N];

        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(inputCards[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++) {
                    int sum = 0;
                    sum = cards[i] + cards[j] + cards[k];
                    if(M == sum) {
                        System.out.println(M);
                        return;
                    }
                    else if(M >= sum) {
                        list.add(M - sum);
                    }
                }
            }
        }
        Collections.sort(list);

        System.out.println(M - list.get(0));

    }
}
