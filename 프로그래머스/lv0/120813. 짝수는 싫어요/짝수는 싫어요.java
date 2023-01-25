import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();  // List를 사용하면 배열 크기 정하지 않아도 된다.
        for (int i = 1; i <= n; i++)
            if (i % 2 != 0)
                list.add(i);

        return list.stream().mapToInt(Integer::intValue).toArray();  // 대신, list를 int 배열로 바꾸는게 조금 까다로워진다.
    }
}