class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder();
        String[] str = my_string.split("");

        for (int i = 0; i < str.length; i++) {
            String tmp = "";
            if (i == num1) {
                sb.append(str[num2]);
            }
            else if (i == num2) {
                sb.append(str[num1]);
            } else {
                sb.append(str[i]);
            }
        }

        return sb.toString();
    }
}
