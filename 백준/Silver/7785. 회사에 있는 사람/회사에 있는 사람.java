import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        // 직원들 출퇴근 정보 기록하기 위한 entry 생성
        Map<String, String> entry = new HashMap<>();

        for(int i = 0; i < num; i++) {
            String peopleInfo = br.readLine();
            String[] info = peopleInfo.split(" ");
            String name = info[0];
            String status = info[1];

            entry.put(name, status);
        }

        ArrayList<String> remains = new ArrayList<>();

        // enter인 직원들만 remains에 저장
        for (Map.Entry<String, String> entrySet : entry.entrySet()) {
            if ("enter".equals(entrySet.getValue())) {
                remains.add(entrySet.getKey());
            }
        }

        remains.sort(Collections.reverseOrder());

        for (String person : remains) {
            System.out.println(person);
        }

    }
}
