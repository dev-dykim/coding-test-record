class Solution {
    public int[] solution(int[] num_list) {
        int evenCnt = 0;
        int oddCnt = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0)
                evenCnt++;
            else 
                oddCnt++;
        }
        
        return new int[]{evenCnt, oddCnt};
    }
}