import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] nums = new String[numbers.length];

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            nums[i] = numbers[i] + "";
        }

        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        for (int i = 0; i < len; i++) {
            answer += nums[i];
        }

        return answer.charAt(0) == '0' ? "0" : answer;
    }
}