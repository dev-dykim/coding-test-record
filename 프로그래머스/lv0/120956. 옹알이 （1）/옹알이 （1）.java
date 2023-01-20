class Solution {
    public int solution(String[] babbling) {
        String words[] = {"aya", "ye", "woo", "ma"};
        int cnt = 0;

        for (String target : babbling) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(target)) {
                    cnt++;
                    break;
                } else {
                    if (target.length() >= words[i].length() && words[i].equals(target.substring(0, words[i].length()))) {
                        target = target.substring(words[i].length());
                        i = -1;
                    }
                }
            }
        }
        return cnt;
    }
}