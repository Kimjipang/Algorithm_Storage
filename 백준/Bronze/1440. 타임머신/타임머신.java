import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] localDate = br.readLine().split(":");

        int len = localDate.length;
        int count = 0;
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                for(int k = 0; k < len; k++) {
                    if(i != j && i != k && j != k && readAble(localDate[i], localDate[j], localDate[k])) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
    public static boolean readAble(String h, String m, String s) {
        boolean flag = false;

        int hour = Integer.parseInt(h);
        int minute = Integer.parseInt(m);
        int second = Integer.parseInt(s);

        if(hour >= 1 && hour <= 12 && minute >= 0 && minute <= 59 && second >= 0 && second <= 59) {
            flag = true;
        }

        return flag;
    }
}
