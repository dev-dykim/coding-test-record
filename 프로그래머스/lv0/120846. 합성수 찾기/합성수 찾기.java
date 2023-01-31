class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 4; i <= n; i++) { // 1, 2, 3은 합성수가 아니므로 4부터 시작
            if (isComposite(i)) answer++;
        }
        
        return answer;
    }

    private boolean isComposite(int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                cnt++;
            if (cnt >= 3)
                return true;
        }
        return false;
    }
}
