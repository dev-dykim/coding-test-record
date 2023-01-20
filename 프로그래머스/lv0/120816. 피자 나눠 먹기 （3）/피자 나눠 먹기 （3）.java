class Solution {
    public int solution(int slice, int n) {
        return countPizza(n, slice, 1);
    }
    
    int countPizza(int num, int slice, int cnt) {
        if (num <= slice)
            return cnt;
        else
            return countPizza(num - slice, slice, ++cnt);
    }
}