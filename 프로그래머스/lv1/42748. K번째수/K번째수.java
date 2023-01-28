import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for (int[] command : commands) {
            int tmp = 0;
            for (int idx = 0; idx < command.length; idx++) {
                int i = command[0];
                int j = command[1];
                int k = command[2];
                int[] new_arr = Arrays.copyOfRange(array, (i-1), j);
                System.out.println(Arrays.toString(new_arr));
                Arrays.sort(new_arr);
                tmp = new_arr[k-1];
                System.out.println(tmp);
            }
            answer[index++] = tmp;
        }
        return answer;
    }
}
