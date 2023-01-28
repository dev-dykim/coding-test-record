import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder());

        for (String ss : str)
            sb.append(ss);

        return sb.toString();
    }
}
