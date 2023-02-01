import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer>[] boardStack = new Stack[board.length + 1];
        Stack<Integer> basket = new Stack<>();

        for (int i = 0; i < boardStack.length; i++) {
            boardStack[i] = new Stack<>();
        }

        for (int j = 0, idx = 1; j < board.length; j++, idx++) {
            for (int i = board[j].length - 1; i >= 0; i--) {
                if (board[i][j] == 0)
                    break;
                boardStack[idx].push(board[i][j]);
            }
        }
        
        for (int m : moves) {
            if (boardStack[m].isEmpty())
                continue;
            int next = boardStack[m].pop();
            if (!basket.isEmpty() && basket.peek() == next) {
                answer += 2;
                basket.pop();
            } else {
                basket.push(next);
            }
        }

        return answer;
    }
}
