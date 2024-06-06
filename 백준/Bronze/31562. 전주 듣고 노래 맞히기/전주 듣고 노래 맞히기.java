import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[][] musicInfo = new String[N][];
        for(int i = 0; i < N; i++) {
            musicInfo[i] = br.readLine().split(" ");
        }

        for(int j = 0; j < M; j++) {
            int cnt = 0;
            String code = br.readLine().replaceAll(" ", "");
            ArrayList<String> list = new ArrayList<>();

            for(int i = 0; i < N; i++) {
                if((musicInfo[i][2] + musicInfo[i][3] + musicInfo[i][4]).equals(code)) {
                    list.add(musicInfo[i][1]);
                }
            }
            int listSize = list.size();
            if(listSize == 1) {
                System.out.println(list.get(0));
            }
            else if(listSize > 1) {
                System.out.println("?");
            }
            else {
                System.out.println("!");
            }
        }
    }
}
