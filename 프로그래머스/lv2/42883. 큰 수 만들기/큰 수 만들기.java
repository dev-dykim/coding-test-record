import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int eraseCnt = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(number.charAt(i));
            } else {
                while (eraseCnt < k && !stack.isEmpty() && stack.peek() < number.charAt(i)) {
                    stack.pop();
                    eraseCnt++;
                }
                stack.push(number.charAt(i));
            }
        }

        while (eraseCnt < k) {
            stack.pop();
            eraseCnt++;
        }

        for (Character ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}