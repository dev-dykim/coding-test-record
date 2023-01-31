class Keypad {
    int num;
    int row;
    int col;

    public Keypad(int num, int row, int col) {
        this.num = num;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Keypad[] keypad = new Keypad[10];

        // Keypad 클래스에 번호(num), 번호판의 row, col 정보 넣기
        keypad[0] = new Keypad(0, 3, 1);
        for (int idx = 1; idx < 10; idx++) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    keypad[idx] = new Keypad(idx++, r, c);
                }
            }
        }

        int[] L = {3, 0}; // {L의 row, L의 col} 처음 위치
        int[] R = {3, 2}; // {R의 row, R의 col} 처음 위치

        for (int n : numbers) {
            if (n == 1 | n == 4 | n == 7) {
                sb.append("L");
                L[0] = n / 3;
                L[1] = 0;
            } else if (n == 3 | n == 6 | n == 9) {
                sb.append("R");
                R[0] = n / 3 - 1;
                R[1] = 2;
            } else {
                int L_dist = Math.abs(keypad[n].row - L[0]) + Math.abs(keypad[n].col - L[1]);
                int R_dist = Math.abs(keypad[n].row - R[0]) + Math.abs(keypad[n].col - R[1]);
                String next;
                if (L_dist == R_dist) {
                    next = hand.equals("right") ? "R" : "L";
                }
                else {
                    next = L_dist < R_dist ? "L" : "R";
                }
                if (next.equals("R")) {
                    sb.append("R");
                    R[0] = keypad[n].row;
                    R[1] = keypad[n].col;
                } else {
                    sb.append("L");
                    L[0] = keypad[n].row;
                    L[1] = keypad[n].col;
                }
            }
        }

        return sb.toString();
    }
}
