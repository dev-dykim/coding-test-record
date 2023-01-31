import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        StringBuilder sb = new StringBuilder();
        String[] str = dartResult.split("");
        int[] scores = new int[3];
        int idx = -1;
        int score = 0;

        for (int i = 0; i < str.length; i++) {
            if (i+1 < str.length && str[i].equals("1") && str[i+1].equals("0")) {
                score = 10;
                i += 2;
            } else if (str[i].matches("[0-9]")) {
                score = Integer.parseInt(str[i]);
            }

            if (str[i].equals("S"))
                scores[++idx] = score;
            else if (str[i].equals("D"))
                scores[++idx] = (int) Math.pow(score, 2);
            else if (str[i].equals("T"))
                scores[++idx] = (int) Math.pow(score, 3);
            else if (str[i].equals("*")) {
                if (idx - 1 >= 0)
                    scores[idx - 1] *= 2;
                scores[idx] *= 2;
            } else if (str[i].equals("#")) {
                scores[idx] *= -1;
            }
        }

        int sum = 0;
        for (int s : scores)
            sum += s;

        return sum;
    }
}
