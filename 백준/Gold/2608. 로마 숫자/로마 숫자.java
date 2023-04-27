import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String[] strings = new String[2];
    static Map<String, Integer> map = new HashMap<>();

    static void init() {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }

    static void input() {
        strings[0] = scan.next();
        strings[1] = scan.next();
    }

    static void pro() {
        int sum = getNum(strings[0].split("")) + getNum(strings[1].split(""));
        String romeNum = getRomeNum(sum);
        System.out.println(sum);
        System.out.println(romeNum);
    }

    private static int getNum(String[] s) {
        int num = 0;
        for (int i = 0; i < s.length; i++) {
            if (i < s.length - 1 && (s[i].equals("I") || s[i].equals("X") || s[i].equals("C"))) {
                int val = map.getOrDefault(s[i] + s[i+1], 0);
                if (val != 0) {
                    num += val;
                    i++;
                    continue;
                }
            }
            num += map.get(s[i]);
        }
        return num;
    }

    private static String getRomeNum(int num) {
        for (int i = 0; i < num / 1000; i++) {
            sb.append("M");
        }
        int numOf1000 = num / 1000 * 1000;
        int numOf100 = (num - (numOf1000)) / 100 * 100;
        if (numOf100 == 900) {
            sb.append("CM");
        } else if (numOf100 > 500) {
            sb.append("D");
            for (int i = 0; i < (numOf100 - 500) / 100; i++) {
                sb.append("C");
            }
        } else if (numOf100 == 500) {
            sb.append("D");
        } else if (numOf100 == 400) {
            sb.append("CD");
        } else {
            for (int i = 0; i < numOf100 / 100; i++) {
                sb.append("C");
            }
        }

        int numOf10 = (num - (numOf1000 + numOf100)) / 10 * 10;
        if (numOf10 == 90) {
            sb.append("XC");
        } else if (numOf10 > 50) {
            sb.append("L");
            for (int i = 0; i < (numOf10 - 50) / 10; i++) {
                sb.append("X");
            }
        } else if (numOf10 == 50) {
            sb.append("L");
        } else if (numOf10 == 40) {
            sb.append("XL");
        } else {
            for (int i = 0; i < (numOf10 / 10); i++) {
                sb.append("X");
            }
        }

        int numOf1 = (num - (numOf1000 + numOf100 + numOf10));
        if (numOf1 == 9) {
            sb.append("IX");
        } else if (numOf1 > 5) {
            sb.append("V");
            for (int i = 0; i < (numOf1 - 5); i++) {
                sb.append("I");
            }
        } else if (numOf1 == 5) {
            sb.append("V");
        } else if (numOf1 == 4) {
            sb.append("IV");
        } else {
            for (int i = 0; i < numOf1; i++) {
                sb.append("I");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        init();
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}