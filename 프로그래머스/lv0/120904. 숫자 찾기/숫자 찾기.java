import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int num, int k) {
        List<Integer> list = new ArrayList<>();
        String[] str = String.valueOf(num).split("");
        for (String s : str) {
            list.add(Integer.parseInt(s));
        }

        return list.contains(k) ? list.indexOf(k) + 1 : -1;
    }
}
