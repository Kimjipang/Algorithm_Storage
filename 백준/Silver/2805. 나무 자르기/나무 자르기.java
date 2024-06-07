import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        int M = Integer.parseInt(st.nextToken()); // 필요한 나무 길이

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) {
                max = trees[i]; // 가장 큰 나무의 높이
            }
        }

        // 이분 탐색을 통한 절단기 높이 최적화
        int low = 0;
        int high = max;
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long total = 0;

            for (int tree : trees) {
                if (tree > mid) {
                    total += (tree - mid);
                }
            }

            if (total >= M) {
                result = mid; // 현재 높이를 기록
                low = mid + 1; // 더 높은 절단기 높이를 시도
            } else {
                high = mid - 1; // 더 낮은 절단기 높이를 시도
            }
        }

        System.out.println(result);
    }
}
