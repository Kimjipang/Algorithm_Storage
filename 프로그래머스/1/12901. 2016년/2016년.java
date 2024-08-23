class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int total_days = 0;
        
        for (int i = 1; i < a; i++) {
            total_days += months[i];
        }
        total_days += b;
        System.out.println(total_days);
        answer = days[total_days % 7];
        
        return answer;
    }
}