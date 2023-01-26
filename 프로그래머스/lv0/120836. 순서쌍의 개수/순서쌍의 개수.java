class Solution {
    public int solution(int n) {
        int answer = 0;
        double sqrt = Math.sqrt(n);  // n의 제곱근 구하기
        for (int i = 1; i <= (int) sqrt; i++) { // n의 제곱근까지만 for 문 돌면서 약수 구하면 된다. 제곱근까지 돌면서 구한 개수에 2를 곱하면 된다.
            if (i * i == n) answer++;  // i가 n의 제곱근인 경우는 하나이므로 1을 더한다.
            else if (n % i == 0) answer += 2;  // i가 n의 약수인 경우, 순서쌍이므로 2를 더한다.
        }
        return answer;
    }
}