class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int sum1 = 0;
        int sum2 = 0;
        
        for (int num : arr1) {
            sum1 += num;
        }
        
        for (int num: arr2) {
            sum2 += num;
        }
        
        if (arr1.length == arr2.length) {
            if (sum1 == sum2) {
                return 0;
            }
            else {
                return sum1 > sum2 ? 1 : -1;
            }
        }
        
        return arr1.length > arr2.length ? 1 : -1;
    }
}