import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String[] status = br.readLine().split(" ");
        int [] switchStatus = new int[num];

        for(int i = 0; i < num; i++) {
            switchStatus[i] = Integer.parseInt(status[i]);
        }

        int total = Integer.parseInt(br.readLine());

        for(int i = 0; i < total; i++) {
            String input = br.readLine();
            int gender = Integer.parseInt(input.split(" ")[0]);
            int allocated = Integer.parseInt(input.split(" ")[1]);

            if(gender == 1) {
                for(int j = allocated -1; j < num; j += allocated) {
                    switchStatus[j] = 1 - switchStatus[j];
                }
            }
            else if(gender == 2) {
                int left = allocated - 2;
                int right = allocated;
                switchStatus[allocated - 1] = 1 - switchStatus[allocated - 1];
                while(left >= 0 && right < num && switchStatus[left] == switchStatus[right]) {
                    switchStatus[left] = 1- switchStatus[left];
                    switchStatus[right] = 1 - switchStatus[right];
                    left--;
                    right++;
                }
            }
        }
        for(int i = 0; i < num; i++) {
            System.out.print(switchStatus[i] + " ");
            if((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}
