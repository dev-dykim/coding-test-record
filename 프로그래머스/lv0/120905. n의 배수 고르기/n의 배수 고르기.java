import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> list = new ArrayList<>();

        for (int num : numlist) {
            if (num % n == 0)
                list.add(num);
        }

        int[] answer = new int[list.size()];
        int idx = 0;
        for (int num : list) {
            answer[idx++] = num;
        }

        return answer;
    }
}
