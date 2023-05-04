import java.util.*;

class Solution {

    static String[] orders;

    public String[] solution(String[] orders, int[] course) {
        this.orders = orders;
        Set<Character> set = new HashSet<>();
        for (String order : orders) {
            for (int i = 0; i < order.length(); i++) {
                set.add(order.charAt(i));
            }
        }

        String[] arr = new String[set.size()];
        int idx = 0;
        for (Character ch : set) {
            arr[idx++] = String.valueOf(ch);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            String[] target = new String[course[i]];
            Boolean[] used = new Boolean[arr.length];
            for (int j = 0; j < used.length; j++) {
                used[j] = false;
            }
            findCourse(arr, target, used, course[i], 0, map, 0);
            if (!map.isEmpty()) {
                Map.Entry<String, Integer> maxEntry = Collections.max(map.entrySet(), Map.Entry.comparingByValue());
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() >= 2 && entry.getValue()
                            .equals(maxEntry.getValue())) {
                        list.add(entry.getKey());
                    }
                }
            }
        }

        Collections.sort(list);
        return list.toArray(new String[0]);
    }

    private void findCourse(String[] arr, String[] target, Boolean[] used, int n, int k, Map<String, Integer> map, int start) {
        if (k == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < target.length; i++) {
                sb.append(target[i]);
            }
            checkCourse(sb.toString(), map);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (used[i]) continue;
            target[k] = arr[i];
            used[i] = true;
            findCourse(arr, target, used, n,k+1, map, i + 1);
            used[i] = false;
        }
    }

    private void checkCourse(String str, Map<String, Integer> map) {

        for (String order : orders) {
            boolean isInclude = false;
            for (int i = 0; i < str.length(); i++) {
                isInclude = false;
                if (!order.contains(String.valueOf(str.charAt(i)))) break;
                isInclude = true;
            }
            if (isInclude) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
    }
}