class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n+1];
        for (int i = 1; i <= n; i++) {
            students[i] = 1;
        }
        
        for (int l : lost) {
            students[l]--;
        }
        
        for (int r : reserve) {
            students[r]++;
        }
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] == 0) {
                if (i >= 2 && students[i-1] == 2) {
                    students[i-1]--;
                    students[i]++;
                } else if (i < n && students[i+1] == 2) {
                    students[i+1]--;
                    students[i]++;
                }
            }
            
            if (students[i] >= 1)
                ans++;
        }
        
        return ans;
    }
}