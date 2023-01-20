class Solution {
    public int solution(int n) {
        return n / getLcm(n, 6);
    }
    
    int getLcm(int a, int b) {
        if (a % b == 0)
            return b;
        return getLcm(b, a % b);
    }
}