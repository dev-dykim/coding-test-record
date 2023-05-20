class Solution {
    static int answer = 0;
    static int[] numbers;
    static int target;
    
    static void rec_func(int k, int sum) {
        if(k == numbers.length) {
            if(sum == target)
                answer++;
        } else {
            rec_func(k+1, sum + numbers[k]);
            rec_func(k+1, sum - numbers[k]);
        }
    }
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        rec_func(0, 0);
        
        return answer;
    }
}