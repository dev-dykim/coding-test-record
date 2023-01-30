import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String s) {
        StringBuilder answer_sb = new StringBuilder();
        StringBuilder temp_sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                answer_sb.append(Character.getNumericValue(ch));
            } else {
                temp_sb.append(ch);
                if (map.get(temp_sb.toString()) != null) {
                    answer_sb.append(map.get(temp_sb.toString()));
                    temp_sb.setLength(0);
                }
            }
        }

        return Integer.parseInt(answer_sb.toString());
    }
}
