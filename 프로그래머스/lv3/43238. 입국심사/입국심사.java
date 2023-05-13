class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long L = 1, R = 1000000000000000000L;
        
        while (L <= R) {
            long mid = (L+R)/2;
            if (isPossible(mid, times, n)) {
                answer = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return answer;
    }

    private boolean isPossible(long minutes, int[] times, int n) {
        long people = 0;
        for (int t : times) {
            people += minutes / t;
        }
        
        return people >= n;
    }
}