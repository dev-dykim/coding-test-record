## 문제 설명

- 매개변수 : 문자열 `s`
- 리턴값 : `s` 의 각 문자마다, 현재 문자 이전에 있는 문자 중, 현재 문자와 동일한 문자가 몇번째 앞에 있는지 담은 int 배열
- 제한사항
    - 1 ≤ `s` 의 길이 ≤ 10,000

---

## 설계

1. Map<Character, Integer> 을 만든다.
    - Map에는 현재 문자와 현재 인덱스 번호를 넣을 것이다.
2. map이 현재 문자(i번째)를 key를 갖고 있는지 확인한다.
    1. key로 갖고 있으면, answer[i] 에 `(현재 index) - (key의 value값: 해당 문자의 이전 인덱스 값)`을 넣는다.
    2. key로 갖고 있지 않으면, answer[i] 에 `-1` 을 넣는다.
3. map에 현재 문자와 인덱스 값을 갱신해서 넣는다.
4. 문자열이 가진 모든 문자에 대해서 2~3을 반복한다.

---

## 코드

```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> map = new HashMap<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            answer[i] = i - map.getOrDefault(s.charAt(i), i + 1);
            map.put(s.charAt(i), i);
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

- 처음에 이중 for문으로 s 문자열 길이만큼 돌고, 현재문자 바로 이전까지 substr로 자른 문자열을 for문으로 또 돌면서 문자 하나씩 비교하려고 했다. 근데 문자열이 최대 10,000 글자여서 이중 for문 돌면 너무 비효율적이라 Map에 넣어서 풀었다.
