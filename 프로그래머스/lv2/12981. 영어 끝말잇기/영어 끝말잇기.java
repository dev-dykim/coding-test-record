import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for(String word : words) {
            int cnt = (idx + 1) % n == 0 ? (idx + 1) / n : (idx + 1) / n + 1;
            int mem = (idx + 1) % n == 0 ? n : (idx + 1) % n;
            if(idx > 0 && words[idx-1].charAt(words[idx-1].length()-1) != word.charAt(0)){
                return new int[] {mem, cnt};
            }
            
            if(!map.containsKey(word)){
                map.put(word, mem);
            }
            else {
                return new int[] {mem, cnt};
            }
            
            if(word.length() == 1) {
                return new int[] {mem, cnt};
            }
            
            idx++;
        }
        return new int[] {0, 0};
    }
}
