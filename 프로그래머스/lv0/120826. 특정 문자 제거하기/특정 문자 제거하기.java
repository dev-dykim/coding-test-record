class Solution {
    public String solution(String my_string, String letter) {
        return my_string.replaceAll(letter, "");    // replaceAll 이용하여 letter 글자를 ""로 모두 바꾼다.
    }
}