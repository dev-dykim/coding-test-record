class Solution {
    public boolean solution(int x) {
        int num = 0;
        String numStr = String.valueOf(x);
        String[] numArr = numStr.split("");
        for (String n : numArr) {
            num += Integer.parseInt(n);
        }

        return (x % num == 0) ? true : false;
    }
}
