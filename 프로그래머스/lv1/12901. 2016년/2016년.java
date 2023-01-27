import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(int a, int b) {
        int numOfDay = 0; // 2016년의 몇번째 날
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        Map<Integer, Integer> daysMap = new HashMap(); // 달별 일자 저장
        daysMap.put(1, 31);
        daysMap.put(2, 29);
        daysMap.put(3, 31);
        daysMap.put(4, 30);
        daysMap.put(5, 31);
        daysMap.put(6, 30);
        daysMap.put(7, 31);
        daysMap.put(8, 31);
        daysMap.put(9, 30);
        daysMap.put(10, 31);
        daysMap.put(11, 30);
        daysMap.put(12, 31);
        
        // a월 b일이 몇번쨰 날인가 -> (1 ~ a-1) + b
        for (int i = 1; i < a; i++) {
            numOfDay += daysMap.get(i);
        }
        numOfDay += b;
        
        return day[numOfDay % 7];
    }
}
