import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int num ,int k) {
        String str = String.valueOf(num);
        int index = str.indexOf(String.valueOf(k));
        return index != -1 ? index + 1 : index;
    }
}
