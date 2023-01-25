import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        Arrays.sort(array);
        for (int i : array) {
            if (i == n)
                answer++;
            else if (i > n)
                break;
        }
        return answer;
    }
}