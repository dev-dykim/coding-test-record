class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        int idx = num_list.length - 1;
        for (int num : num_list) {
            answer[idx--] = num;
        }
        return answer;
    }
}