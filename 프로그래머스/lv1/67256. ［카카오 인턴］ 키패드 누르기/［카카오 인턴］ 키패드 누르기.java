class Keypad {
    private String name;
    private int row;
    private int col;

    public Keypad(String name, int row, int col) {
        this.name = name;
        this.row = row;
        this.col = col;
    }

    public void setRowCol(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public String getName() {
        return name;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    int getDistance(Keypad k) {
       return Math.abs(k.row - this.row) + Math.abs(k.col - this.col); 
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
                next = left.getName();
                left.setRowCol(n/3, 0);
            } else if (n == 3 | n == 6 | n == 9) {
                next = right.getName();
                right.setRowCol(n/3 - 1, 2);
            } else if (left.getDistance(keypad[n]) == right.getDistance(keypad[n])) {
                next = hand.equals("right") ? right.getName() : left.getName();
            } else
                next =left.getDistance(keypad[n]) < right.getDistance(keypad[n]) ? left.getName() : right.getName();
            
            if (next.equals(right.getName())) {
                sb.append(right.getName());
                right.setRowCol(keypad[n].getRow(), keypad[n].getCol());
            } else {
                sb.append(left.getName());
                left.setRowCol(keypad[n].getRow(), keypad[n].getCol());
            }
        }

        return sb.toString();
    }
}
