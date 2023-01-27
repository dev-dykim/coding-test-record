import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int a : arr)
            if (a < min)
                min = a;

        List<Integer> list = new ArrayList<>();
        for (int a : arr)
            list.add(a);

        list.remove(list.indexOf(min));

        if (list.size() == 0)
            return new int[] {-1};
        else
            return list.stream().mapToInt(i -> i).toArray();

    }
}