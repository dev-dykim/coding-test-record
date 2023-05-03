

import java.util.Stack;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= s.length(); i++) {
            if (i >= answer) break;
            int count = 1;
            for (int j = 0; ;j=j+i) {
                String target;
                boolean end = false;
                if (j+i >= s.length()) {
                    target = s.substring(j);
                    end = true;
                } else {
                    target = s.substring(j, j + i);
                }
                
                if (stack.isEmpty()) {
                    stack.add(target);
                } else if (stack.peek().equals(target)) {
                    count++;
                } else {
                    if (count != 1) {
                        sb.append(count).append(stack.pop());
                    } else {
                        sb.append(stack.pop());
                    }
                    stack.add(target);
                    count = 1;
                }

                if (end) {
                    if (count != 1) {
                        sb.append(count).append(stack.pop());
                    } else {
                        sb.append(stack.pop());
                    }
                    answer = Math.min(sb.length(), answer);
                    sb.setLength(0);
                    break;
                }
            }
        }

        return answer;
    }
}