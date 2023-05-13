import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        for (int n : numbers) {
            list.add(n);
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Integer.parseInt("" + o1 + o2) > Integer.parseInt("" + o2 + o1)) {
                    return -1;
                } else if (Integer.parseInt("" + o1 + o2) < Integer.parseInt("" + o2 + o1)) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        for (int num : list) {
            sb.append(String.valueOf(num));
        }
        
        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }
}
