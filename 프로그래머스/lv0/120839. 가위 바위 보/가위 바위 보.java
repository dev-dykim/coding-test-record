import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> rspMap = new HashMap<>();
        rspMap.put("2", "0");
        rspMap.put("0", "5");
        rspMap.put("5", "2");

        for (int i = 0; i < rsp.length(); i++) {
            sb.append(rspMap.get(String.valueOf(rsp.charAt(i))));
        }

        return sb.toString();
    }
}
