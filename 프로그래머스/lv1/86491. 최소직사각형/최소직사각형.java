import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int w_max = 0, h_max = 0;
        for (int[] size : sizes) {
            Arrays.sort(size);
        }
        for (int i = 0; i < sizes.length; i++) {
            w_max = (w_max < sizes[i][0]) ? sizes[i][0] : w_max;
            h_max = (h_max < sizes[i][1]) ? sizes[i][1] : h_max;
        }
        
        return w_max * h_max;
    }
}
