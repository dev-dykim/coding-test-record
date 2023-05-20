class Solution {
    public int solution(int n, int[][] results) {
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = 5000;
            }
        }

        for (int[] result : results) {
            int x = result[0];
            int y = result[1];
            arr[x][y] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }

        int[] columnSum = new int[n+1];
        int[] rowSum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] != 5000) {
                    rowSum[i]++;
                    columnSum[j]++;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (columnSum[i] + rowSum[i] == n-1)
                answer++;
        }

        return answer;
    }
}
