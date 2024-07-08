class Solution {
    public int[] solution(int[] arr) {
        int num = 0;
        int[] result = new int[arr.length - 1];
        if(arr.length == 1) {
            int[] result1 = { -1 };
            return result1;
        }
        int min = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
                num = i;
            }
        }
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(num == i)
                continue;
                result[index++] = arr[i];
        }
        return result;
    }
}