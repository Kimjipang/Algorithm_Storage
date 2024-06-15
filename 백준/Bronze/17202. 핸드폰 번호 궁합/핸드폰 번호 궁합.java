import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputA = br.readLine().split("");
        String[] inputB = br.readLine().split("");

        String num = numberJoin(inputA, inputB);

        while(num.length() != 2) {
            String combi = "";
            for(int i = 0; i < num.length() - 1; i++) {
                for(int j = i + 1; j < i + 2; j++) {
                    combi += String.valueOf(charToInt(num.charAt(i), num.charAt(j)));
                }
            }
            num = combi;
        }

        System.out.println(num);
    }
    private static String numberJoin(String[] inputA, String[] inputB) {
        String num = "";
        for(int i = 0; i < 8; i++) {
            num += inputA[i] + inputB[i];    
        }
        return num;
    }
    private static int charToInt(char word1, char word2) {
        int result = (Integer.parseInt(String.valueOf(word1)) + Integer.parseInt(String.valueOf(word2))) % 10;

        return result;
    }
}
