class Solution {
    static int N, number, answer = Integer.MAX_VALUE;
    static int[] arr;

    public int solution(int N, int number) {
        this.N = N;
        this.number = number;

        arr = new int[8];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] * 10 + N;
        }

        rec_func(0, 0);

        return answer > 8 ? -1 : answer;
    }

    private void rec_func(int result, int cnt) {
        if (cnt > 8 || result == number) {
            answer = Math.min(answer, cnt);
        } else {
            for (int i = 1; i < arr.length; i++) {
                rec_func(result + arr[i], cnt + i);
                rec_func(result - arr[i], cnt + i);
                rec_func(result * arr[i], cnt + i);
                rec_func(result / arr[i], cnt + i);
            }
        }
    }
}