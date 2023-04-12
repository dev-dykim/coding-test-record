import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        int[] sortedScore =  Arrays.stream(score).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < sortedScore.length / m; i++) {
            answer += sortedScore[m*i+(m-1)] * m;
        }
        
        return answer;
    }
}

