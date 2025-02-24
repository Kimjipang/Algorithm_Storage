class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String even_num = "";
        String odd_num = "";
        
        for (int num : num_list) {
            if (num % 2 == 0) {
                even_num += String.valueOf(num);
            }
            else {
                odd_num += Integer.toString(num);
            }
        }
        
        answer = Integer.parseInt(even_num) + Integer.parseInt(odd_num);
        
        return answer;
        
    }
}