class Solution {
    static  int cnt;

    public int solution(int[] nums) {
        selectNums(nums, 0, 0, -1);
        return cnt;
    }

    private void selectNums(int[] nums, int k, int sum, int last) {
        if (k == 3) {
            if (isPrime(sum))
                cnt++;
        } else {
            for (int idx = last + 1; idx < nums.length; idx++) {
                last = idx;
                selectNums(nums, k + 1, sum + nums[idx], last);
            }
        }
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
