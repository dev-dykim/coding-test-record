## 문제 설명

- 매개변수 : `t`, `p` - 숫자로 이루어진 문자열
- 리턴값 : `t` 의 부분 문자열의 숫자가 `p` 의 숫자보다 작거나 같은 경우의 수
- 제한사항
    - 1 ≤ `p` 의 길이 ≤ 18
    - `p` 의 길이 ≤ `t` 의 길이 ≤ 10,000
    - `t` , `p` 는 숫자로만 이루어진 문자열, 0으로 시작하지 않는다.

---

## 설계

1. t 문자열의 0번째 글자부터 (t 길이 - p 길이)번째 글자까지 다음을 반복한다.
    1. t 의 i 번째 글자부터 p 길이 만큼 자른다.(substring)
    2. a를 숫자로 바꾼다.
    3. 숫자로 바꾼 p 와 b 를 비교한다.
        1. b ≤ p 이면 answer를 1 올린다.

---

## 코드

```java
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            if (Long.parseLong(t.substring(i, i + p.length())) <= Long.parseLong(p))
                answer++;
        }
        return answer;
    }
}
```

---

## 시간 복잡도

- O(n)

---

## 어려웠던 점

- 처음에 `Integer.parseInt` 를 썼다가 테스트케이스에서 런타임에러가 났다. `p` 의 최대 길이가 18이므로, 문자열을 숫자로 바꾸면 `Integer` 범위를 넘게 된다.
    
    → 변수의 최대값의 범위를 잘 살펴보자!
