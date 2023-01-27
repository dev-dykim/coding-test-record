import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> playerMap = new HashMap<>();
        for (String player : participant)
            playerMap.put(player, playerMap.getOrDefault(player, 0) + 1);

        for (String complete : completion)
            playerMap.put(complete, playerMap.get(complete) - 1);

        for (Map.Entry<String, Integer> entry : playerMap.entrySet()) {
            if (entry.getValue().equals(1))
                answer = entry.getKey();
        }

        return answer;
    }
}