import java.util.Arrays;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String format = "%" + n + "s";
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = String.format(format, binary);
            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("0", " ");
        }

        return answer;
    }
}
