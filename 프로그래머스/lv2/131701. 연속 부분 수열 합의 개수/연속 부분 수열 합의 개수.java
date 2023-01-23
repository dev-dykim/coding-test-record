import java.util.HashSet;
import java.util.Set;

class Solution {
    static int[] elements;

    public int solution(int[] elements) {
        this.elements = elements;
        Set<Integer> set = new HashSet<>();


        int len = elements.length;
        for (int i = 0; i < len; i++) {
            find_sum(i, (len + (i - 1)), 0, set, len);
        }

        return set.size();
    }

    void find_sum(int select, int end, int value, Set set, int len) {
        if (select == end) {
            set.add(value);
        } else {
            for (int select_cnt = 1; select_cnt < end; select_cnt++) {
                if (select == select_cnt)
                    set.add(value);
            }
            find_sum(select + 1, end, value + elements[(select + 1) % len], set, len);
        }
    }
}