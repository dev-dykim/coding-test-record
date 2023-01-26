class Solution {
    public int solution(int n) {
        double sqrt = Math.sqrt(n); // 제곱근 구하기
        return (int)sqrt * (int)sqrt == n ? 1 : 2;
    }
}
