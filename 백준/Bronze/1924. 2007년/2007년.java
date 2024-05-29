import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0;
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        
        int month = scan.nextInt();
        int day = scan.nextInt();
        
        for(int i = 0; i < month - 1; i++) {
            sum += arr[i];
        }
        sum += day;
        
        sum %= 7;
        
        System.out.print(days[sum]);
        
    }
}