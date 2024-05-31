import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        시간 제한 1초
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Set<String> logs = new HashSet<>();
        int usedCnt = 0;

        for (int i = 0; i < count; i++) {
            String info = br.readLine();
            if (info.equals("ENTER")) { // ENTER와 ENTER사이의 info를 Set에 저장하는 방식으로 하면 됨.
                logs.clear();
            } else {
                if (!logs.contains(info)) {
                    usedCnt++;
                    logs.add(info);
                }
            }
        }
        System.out.println(usedCnt);
    }
}
