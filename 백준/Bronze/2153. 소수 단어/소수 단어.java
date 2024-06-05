import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        아스키 코드를 활용하는 방식으로 접근
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] word = input.toCharArray();
        int sum = 0;
        
        //  대소문자 구분해서 숫자로 변환 후 sum에 합침.
        for(int i = 0; i < word.length; i++) {
            if(Character.isUpperCase(word[i])) {
                sum += word[i] - 38;
            }
            else {
                sum += word[i] - 96;
            }
        }
        System.out.println(checkPrime(sum)); // 소수인지 아닌지 확인하는 메서드
    }

    public static String checkPrime(int num) {
        if(num == 1) {
            return "It is a prime word.";
        }
        else {
            for(int i = 2; i <= num; i++) {
                if(i != num && num % i == 0) {
                    return "It is not a prime word.";
                }
                else if(i == num && num % i ==0) {
                    return "It is a prime word.";
                }
            }
        }
        return null;
    }
}
