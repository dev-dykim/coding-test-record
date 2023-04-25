import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int idx = 0;
        for (String[] photoList : photo) {
            int score = 0;
            for (String p : photoList) {
                score += map.getOrDefault(p, 0);
            }
            answer[idx++] = score;
        }

        return answer;
    }
}