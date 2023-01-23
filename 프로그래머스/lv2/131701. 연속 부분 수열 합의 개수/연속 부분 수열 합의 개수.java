import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();

        int len = elements.length;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                sums.add(find_sum(elements, j, j + i));
            }
        }

        return sums.size();
    }

    int find_sum(int[] elements, int start, int end) {
        int sum = 0;
        int len = elements.length;
        for (int i = start; i < end; i++) {
            sum += elements[i % len];
        }
        return sum;
    }
}