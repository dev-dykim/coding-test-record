import java.util.*;

class Solution {
    public int[] solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0, max = 0;
        for (int a : array) {
            map.put(a, idx++);
            max = Math.max(max, a);
        }

        return new int[] {max, map.get(max)};
    }
}
