import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        List<Integer> lottos_list = new ArrayList<>();
        List<Integer> win_num_list = new ArrayList<>();

        for (int lotto : lottos) {
            lottos_list.add(lotto);
        }

        for (int win : win_nums) {
            win_num_list.add(win);
        }

        int cnt = 0, zero_cnt = 0;
        for (Integer lotto : lottos_list) {
            if (win_num_list.contains(lotto))
                cnt++;
            if (lotto == 0)
                zero_cnt++;
        }

        return new int[] {rank[cnt + zero_cnt], rank[cnt]};
    }
}
