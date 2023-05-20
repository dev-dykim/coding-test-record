class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] arr = new int[len][len];
        arr[0][0] = triangle[0][0];
        for(int i = 1; i < len; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    arr[i][j] = arr[i-1][j] + triangle[i][j];
                } else {
                    arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-1]) + triangle[i][j];
                }
                if(i == len - 1) {
                    answer = Math.max(answer, arr[i][j]);
                }
            }
        }
        return answer;
    }
}