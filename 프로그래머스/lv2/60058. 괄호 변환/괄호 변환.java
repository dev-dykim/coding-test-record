import java.util.Stack;

class Solution {
    public String solution(String p) {

        if (isRight(p)) {
            return p;
        }

        return getStr(p);
    }

    private static String getStr(String p) {
        if (p.equals("")) {
            return "";
        }

        String u = getBalanced(p);
        String v = p.substring(u.length());

        if (isRight(u)) {
            return u + getStr(v);
        } else {
            String emptyStr = "(" + getStr(v) + ")";
            u = u.substring(1, u.length() - 1);
            StringBuilder reverse = new StringBuilder();
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') {
                    reverse.append(")");
                } else {
                    reverse.append("(");
                }
            }
            return emptyStr + reverse.toString();
        }
    }

    private static String getBalanced(String p) {
        int score = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            sb.append(p.charAt(i));
            if (p.charAt(i) == '(') {
                score--;
            }
            if (p.charAt(i) == ')') {
                score++;
            }
            if (score == 0) {
                break;
            }
        }
        return sb.toString();
    }

    private static boolean isRight(String p) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(p.charAt(i));
            } else if (stack.peek().equals('(') && p.charAt(i) == ')') {
                stack.pop();
            } else {
                stack.add(p.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}