import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] arr = new int[k];
        int min = score[0];
        
        
        for (int i = 0; i < score.length; i++) {
            if (i < k) {
                min = Math.min(min, score[i]);
                answer[i] = min;
                arr[i] = score[i];
            }
            else {
                if (i == k) {
                Arrays.sort(arr);
                }
            
                if (arr[0] < score[i]) {
                    arr[0] = score[i];
                }
            
            Arrays.sort(arr);

            answer[i] = arr[0];
            }
        }
        return answer;
    }
}