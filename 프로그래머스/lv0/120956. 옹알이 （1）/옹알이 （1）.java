class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for (String b : babbling) {
            b = b.replace("aya", "1");
            b = b.replace("ye", "1");
            b = b.replace("woo", "1");
            b = b.replace("ma", "1");
            b = b.replace("1", "");
            if (b.isEmpty())
                answer++;
        }
        return answer;
    }
}