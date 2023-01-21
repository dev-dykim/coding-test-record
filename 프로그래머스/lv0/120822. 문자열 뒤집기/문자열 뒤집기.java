class Solution {
    public String solution(String my_string) {
        StringBuffer sb = new StringBuffer();
        for (int i = my_string.length() - 1; i >= 0; i--) {
            sb.append(my_string.charAt(i));
        }
        return sb.toString();
    }
}