class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int result = 1;
        int total = 0;
        
        for (int num : num_list) {
            result *= num;
        }
        
        for (int num : num_list) {
            total += num;
        }
        
        if (result < total * total) {
            return 1;
        }
        
        return answer;
    }
}