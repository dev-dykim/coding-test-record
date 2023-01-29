import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int max = 0;
        int len = numbers.length;
        Arrays.sort(numbers);
        max = Math.max(numbers[0] * numbers[1], numbers[len - 2] * numbers[len - 1]);
        return max;
    }
}
