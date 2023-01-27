class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if(countDivisor(i) % 2 == 0){
                answer+=i;
            }
            else answer-=i;
        }
        return answer;
    }
    public int countDivisor(int num){
        int answer = 0;
        for (int i = 1; i <= (int)Math.sqrt(num); i++) {
            if(num % i == 0){
                if (i * i == num) {
                    answer++;
                }
                else answer+=2;
            }
        }
        return answer;
    }
}