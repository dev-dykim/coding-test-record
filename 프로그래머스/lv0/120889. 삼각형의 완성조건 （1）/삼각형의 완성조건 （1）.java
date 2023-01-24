import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides); // sides 배열 정렬
        if (sides[2] < sides[0] + sides[1]) // 가장 긴 변 < 다른 두 변의 합
            return 1;
        else
            return 2;
    }
}