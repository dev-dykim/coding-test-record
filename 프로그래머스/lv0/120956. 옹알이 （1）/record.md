## 문제 설명

- 주어진 문자 배열  {”aya”, “ye”, “woo”, “ma”}
- 매개변수 : `String[] babbling`
- 리턴값 : `babbling` 배열의 원소 중, 주어진 문자 배열로만 이루어진 원소의 개수
- 제한사항
    - 1 ≤ `babbling` 길이 ≤ 100
    - 1 ≤ `babbling[i]` 길이 ≤ 15
    - `babbling` 각 문자열에서 {주어진 문자 배열}은 각각 최대 한 번만 등장 → 주어진 문자 배열 중복 허용 X

---

## 설계

### #1

- 변수 설정

  > `String words[]` : 주어진 문자 배열을 담는다.
>

1. `babbling` 배열 첫번째 원소부터 마지막 원소까지 반복한다.
    1. `target` = `babbling[i]` 으로 잡고, `words[0]` ~ `words[3]` 까지 `target` 과 비교한다.
        1. `target` 과 `words[i]` 가 같다면, `answer` +1 하고, 1번으로 돌아가 다음 `babbling[i]`을 검사한다.
        2. 다르다면, `target` 을 `words[i]` 글자 수 만큼 잘라서 `words[i]`랑 비교한다.
            1. `target`을 `words[i]` 만큼 자른 글자 == `words[i]` 라면, `words[i]`와 같은 글자를 `target`에서 뺀 값을 `target`에 다시 넣어준다. →  a.로 돌아가서 `target`을 `words[0]` ~ `words[3]` 이랑 비교하면서 아래 수행을 반복한다.
2. 1번 for문을 다 돌고나서 `answer` 값을 리턴한다.

### #2

1. `babbling` 배열 첫번째 원소부터 마지막 원소까지 반복한다.
    1. `babbling[i]` 에서 {주어진 문자 배열}에 해당하는 문자열이 있으면 `replace` 로 해당 문자열을 `1` 로 바꿔준다.
    2. {주어진 문자 배열}의 `replace` 가 모두 끝나고 나면, `babbling[i]`의 `1` 을 `""` 으로 바꿔준다.
    3. `babbling[i]` 가 빈 문자열이면 `answer` 값을 1 올린다.
2. 1번 for문이 끝나면 `answer` 값을 리턴한다.

---

## 코드

### #1

```java
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
```

### #2

```java
class Solution1 {
    public int solution(String[] babblings) {
        int ans = 0;
        for (String babbling : babblings) {
            babbling = babbling.replace("aya", "1");
            babbling = babbling.replace("ye", "1");
            babbling = babbling.replace("woo", "1");
            babbling = babbling.replace("ma", "1");
            babbling = babbling.replace("1", "");

            if (babbling.isEmpty())
                ans++;
        }

        return ans;
    }
}
```

---

## 시간 복잡도

- O(n) 같은 O(n^2)??

---

## 어려웠던 점

- 처음 설계를 너무 원초적(?)으로 했다. 프로그램적 사고 필요!
