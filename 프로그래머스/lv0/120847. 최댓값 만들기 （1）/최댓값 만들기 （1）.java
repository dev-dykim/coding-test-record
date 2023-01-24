import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int last_index = numbers.length - 1;
        return numbers[last_index] * numbers[last_index - 1];
    }
}