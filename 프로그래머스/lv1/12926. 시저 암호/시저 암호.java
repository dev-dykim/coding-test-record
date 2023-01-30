class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ')
                sb.append(ch);
            else if (ch >= 'A' && ch <= 'Z') {
                sb.append(ch + n > 90 ? (char) (ch - 26 + n) : (char) (ch + n));
            }
            else {
                sb.append(ch + n > 122 ? (char) (ch - 26 + n) : (char) (ch + n));
            }
        }

        return sb.toString();
    }
}
