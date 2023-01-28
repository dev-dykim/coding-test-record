import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int w_max = 0, h_max = 0;
        for (int[] size : sizes) {
            Arrays.sort(size);
        }
        for (int i = 0; i < sizes.length; i++) {
            w_max = Math.max(w_max, sizes[i][0]);
            h_max = Math.max(h_max, sizes[i][1]);
        }

        return w_max * h_max;
    }
}
