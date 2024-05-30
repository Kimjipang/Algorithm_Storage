
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int inputNum = Integer.parseInt(br.readLine());
        // 과목 점수 초기화
        double[] inputGrades = Arrays.stream(br.readLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Arrays.sort(inputGrades);
        double sum = 0;
        
        for(int i = 0 ; i < inputGrades.length; i++) {
            sum += (inputGrades[i] / inputGrades[inputGrades.length - 1]) * 100;
        }

        System.out.println(sum / inputNum);
    }
}
