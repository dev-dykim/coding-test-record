import java.util.Arrays;

class Solution {
    public int solution(int order) {
        return (int) Arrays.stream(String.valueOf(order).split("")).filter(s -> s.matches("[369]")).count();
    }
}
