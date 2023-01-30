class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        String[] arr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[] str = String.valueOf(age).split("");
        for (String s : str) {
            int idx = Integer.parseInt(s);
            sb.append(arr[idx]);
        }
        return sb.toString();
    }
}
