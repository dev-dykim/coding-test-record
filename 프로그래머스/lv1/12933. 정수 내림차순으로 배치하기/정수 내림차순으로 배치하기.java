import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        String str = String.valueOf(n);
        String[] arr = str.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        for (String s : arr) 
            sb.append(s);
        return Long.parseLong(sb.toString());
    }
}