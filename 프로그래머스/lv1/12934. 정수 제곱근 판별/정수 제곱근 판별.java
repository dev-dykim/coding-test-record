class Solution {
    public long solution(long n) {
        long answer = 0;
        long sqrt = (long) Math.sqrt(n);
        if (sqrt * sqrt == n)
            answer = (long) Math.pow(((int)sqrt + 1), 2);
        else
            answer = -1;
        return answer;
    }
}