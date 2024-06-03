import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        [전체 넓이 - 빈 넓이] X 1m^2 참외 개수
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int[] direction = new int[6];
        int[] length = new int[6];

        for(int i = 0; i < 6; i++) {
            String input = br.readLine();
            direction[i] = Integer.parseInt(input.split(" ")[0]);
            length[i] = Integer.parseInt(input.split(" ")[1]);
        }

        int maxWidth = 0;
        int maxHeight = 0;
        int maxWidthIdx = -1;
        int maxHeightIdx = -1;

        for(int i = 0; i < 6; i++) {
            if (direction[i] == 1 || direction[i] == 2) {
                if(maxWidth < length[i]) {
                    maxWidth = length[i];
                    maxWidthIdx = i;
                }
            }
            else {
                if(maxHeight < length[i]) {
                    maxHeight = length[i];
                    maxHeightIdx = i;
                }
            }
        }

        int smallWidth = Math.abs(length[(maxHeightIdx + 5) % 6] - length[(maxHeightIdx + 1) % 6]);
        int smallHeight = Math.abs(length[(maxWidthIdx + 5) % 6] - length[(maxWidthIdx + 1) % 6]);

        // 전체 넓이 = 큰 사각형 넓이 - 작은 사각형 넓이
        int bigArea = maxWidth * maxHeight;
        int smallArea = smallWidth * smallHeight;
        int totalArea = bigArea - smallArea;

        // 전체 참외의 개수
        int totalMelons = totalArea * K;

        System.out.println(totalMelons);

        br.close();

    }
}
