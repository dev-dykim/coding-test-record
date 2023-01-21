class Solution {
    public int[] solution(int money) {
        int americano = 5500;
        return new int[] {money / americano, money % americano};
    }
}