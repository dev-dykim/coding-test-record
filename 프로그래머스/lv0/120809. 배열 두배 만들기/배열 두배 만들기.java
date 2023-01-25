class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        int idx = 0;
        for (int num : numbers)
            answer[idx++] = num * 2;
        return answer;
    }
}