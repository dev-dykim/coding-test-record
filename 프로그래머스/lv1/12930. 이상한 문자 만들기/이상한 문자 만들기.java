import java.util.Arrays;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = s.split(" ");
        for (String str : strArr) {
            String[] strArr2 = str.split("");
            int idx = 0;
            for (String str2 : strArr2) {
                if (idx % 2 == 0)
                    sb.append(str2.toUpperCase());
                else
                    sb.append(str2.toLowerCase());
                idx++;
            }
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);

        int spaceFromBack = 0;
        String[] arrForFindSpace = s.split("");
        for (int i = arrForFindSpace.length - 1; i >= 0; i--) {
            if (arrForFindSpace[i].equals(" "))
                spaceFromBack++;
            else
                break;
        }

        for (int i = 0; i < spaceFromBack; i++)
            sb.append(" ");

        return sb.toString();
    }
}