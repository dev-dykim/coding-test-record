import java.util.*;

class Solution {
    public int solution(String before, String after) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : before.split("")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : after.split("")) {
            map.put(s, map.getOrDefault(s, 0) - 1);
        }

        for (Map.Entry<String, Integer> entrySet : map.entrySet()) {
            if (entrySet.getValue() != 0)
                return 0;
        }

        return 1;
    }
}
