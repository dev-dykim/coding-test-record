class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        String[] str = my_string.split("");
        for (String s : str) {
            if (s.charAt(0) >= 'a')
                sb.append(s.toUpperCase());
            else
                sb.append(s.toLowerCase());
        }
        return sb.toString();
    }
}
