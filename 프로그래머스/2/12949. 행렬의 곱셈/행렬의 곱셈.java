class Solution {
    private static int row;
    private static int row2;
    private static int col;
    private static int[][] answer;
    
    private static void calculate(int[][] arr1, int[][] arr2) {
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < row2; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
    }
    
    public int[][] solution(int[][] arr1, int[][] arr2) {
        /*
        두 배열 모두 최대 100 X 100 길이의 배열 O(N^3)까지도 가능
        [풀이]
        행렬 곱셈은 행이랑 열을 곱함
        */
        row = arr1.length;
        row2 = arr2.length;
        col = arr2[0].length;
                
        answer = new int[row][col];
        
        calculate(arr1, arr2);
        return answer;
    }
}