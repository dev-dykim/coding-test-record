import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if (Character.isDigit(ch))
                list.add(Character.getNumericValue(ch));
        }
        Collections.sort(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
}
