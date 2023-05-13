import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int ansIdx = 0;
        for (int[] command : commands) {
            int i = command[0] - 1;
            int j = command[1] - 1;
            int k = command[2] - 1;
            
            int[] arr = new int[j - i + 1];
            for (int idx = i, arrIdx = 0; idx <= j; idx++, arrIdx++) {
                arr[arrIdx] = array[idx];
            }

            Arrays.sort(arr);
            
            answer[ansIdx++] = arr[k];
        }
        
        return answer;
    }
}
