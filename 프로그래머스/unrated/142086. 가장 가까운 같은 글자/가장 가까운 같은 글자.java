import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> map = new HashMap<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            answer[i] = i - map.getOrDefault(s.charAt(i), i + 1);
            map.put(s.charAt(i), i);
        }

        return answer;
    }
}