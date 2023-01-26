class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) { 
            answer += n % i == 0 ? 1 : 0;   // 약수 구하기. n이 i로 나눠지면 answer 값을 1 늘린다.
        }
        return answer;
    }
}