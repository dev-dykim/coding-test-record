import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for (String ss : str) {
            list.add(Integer.parseInt(ss));
        }

        sb.append(Collections.min(list)).append(" ").append(Collections.max(list));

        return sb.toString();
    }
}
