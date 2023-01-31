class Keypad {
    String num;
    int row;
    int col;

    public Keypad(String num, int row, int col) {
        this.num = num;
        this.row = row;
        this.col = col;
    }

    public void setRowCol(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Keypad[] keypad = new Keypad[10];
        Keypad left = new Keypad("L", 3, 0);
        Keypad right = new Keypad("R", 3, 2);

        // Keypad 클래스에 번호(num), 번호판의 row, col 정보 넣기
        keypad[0] = new Keypad("0", 3, 1);
        for (int idx = 1; idx < 10; idx++) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    keypad[idx] = new Keypad(String.valueOf(idx++), r, c);
                }
            }
        }

        for (int n : numbers) {
            String next;
            if (n == 1 | n == 4 | n == 7) {
                next = left.num;
                left.setRowCol(n/3, 0);
            } else if (n == 3 | n == 6 | n == 9) {
                next = right.num;
                right.setRowCol(n/3 - 1, 2);
            } else {
                int L_dist = Math.abs(keypad[n].row - left.row) + Math.abs(keypad[n].col - left.col);
                int R_dist = Math.abs(keypad[n].row - right.row) + Math.abs(keypad[n].col - right.col);

                if (L_dist == R_dist)
                    next = hand.equals("right") ? right.num : left.num;
                else
                    next = L_dist < R_dist ? left.num : right.num;
            }
            if (next.equals(right.num)) {
                sb.append(right.num);
                right.setRowCol(keypad[n].row, keypad[n].col);
            } else {
                sb.append(left.num);
                left.setRowCol(keypad[n].row, keypad[n].col);
            }
        }

        return sb.toString();
    }
}
