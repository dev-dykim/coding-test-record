## 문제 설명

- 매개변수 : 원형 수열 모든 원소 `int[] element`
- 리턴값 : 연속 부분 수열 합으로 만들 수 있는 수의 개수
- 제한사항
    - 3 ≤ element[] 길이 ≤ 1,000
    - 1 ≤ element[] 원소 ≤ 1,000

---

## 설계

1. 부분합을 담을 Set<Integer>을 만든다.
2. 첫번째 원소부터 길이가 1 ~ len 인 부분 수열 합을 구한다.

   ex) 길이가 5이고 시작원소가 3이라면, 인덱스 번호 [start~end] → [3~3], [3~4], [3~5], [3~6], [3~7] 의 합을 구하게 된다.

    1. 시작 인덱스 값에서 길이를 더하면 element 길이가 넘치므로, 원소의 값을 더할 때 index = (end) % len 으로 한다.
3. 구한 합을 set 에 넣는다.
4. set의 사이즈를 리턴한다.

---

## 코드

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();

        int len = elements.length;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                sums.add(find_sum(elements, j, j + i));
            }
        }

        return sums.size();
    }

    int find_sum(int[] elements, int start, int end) {
        int sum = 0;
        int len = elements.length;
        for (int i = start; i < end; i++) {
            sum += elements[i % len];
        }
        return sum;
    }
}

class Solution1 {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();

        int len = elements.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += elements[(i+j) % len];
                sums.add(sum);
            }
        }

        return sums.size();
    }
}

```

---

## 시간 복잡도

- Solution → O(n^3)
- Solution1 → O(n^2)

---

## 어려웠던 점

- 설계는 똑같은데 처음에 구현한 Solution은 3중 for문이었다. 뭔가 sum 구하는 함수를 따로 만들어야 할 것 같아서 그랬는데 불필요한 함수 생성이었다.
- Solution1로 구현하여 시간복잡도 O(n^2)으로 줄였다.
