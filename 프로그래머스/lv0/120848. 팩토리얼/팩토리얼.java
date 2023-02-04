class Solution {
    int factorial(int num, int ans) {
        if (num == 1)
            return ans;
        return factorial(num - 1, ans * (num - 1));
    }
    
    public int solution(int n) {
        int answer = 0;
        for (int i = 1 ; i <= 10; i++) {
            System.out.println(factorial(i, i));
            if (factorial(i, i) > n) {
                break;
            }
            answer = i;
            
        }
        return answer;
    }
}
