class Solution {
    public int[] solution(int n) {
        int[] answer = n % 2 == 0 ? new int[n / 2] : new int[n / 2 + 1];
        for (int i = 1, idx = 0; i <= n; i++) {
            if (i % 2 != 0)  // 홀수일때만
                answer[idx++] = i;  // answer에 넣는다.
        }
        return answer;
    }
}