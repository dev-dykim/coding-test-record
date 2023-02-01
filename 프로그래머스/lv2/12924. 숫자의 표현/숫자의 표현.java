import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n + 1; i++) {
            if (sum < n) {
                queue.add(i);
                sum += i;
            } else if (sum >= n) {
                sum -= queue.poll();
                i--;
            }
            if (sum == n)
                answer++;
        }

        return answer;
    }
}
