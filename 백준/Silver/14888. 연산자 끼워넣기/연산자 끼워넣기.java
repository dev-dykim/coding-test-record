import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] num;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static void input() {
        N = scan.nextInt();
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = scan.nextInt();
        }
        operator = new int[4];
        for (int j = 0; j < 4; j++) {
            operator[j] = scan.nextInt();
        }
    }

    static int calculate(int x, int y, int oper) {
        return switch (oper) {
            case 0 -> x + y;
            case 1 -> x - y;
            case 2 -> x * y;
            case 3 -> x / y;
            default -> 0;
        };
    }

    static void pro(int k, int result) {
        if (k == N-1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int idx = 0; idx < 4; idx++) {
            if (operator[idx] <= 0) continue;
            operator[idx]--;
            pro(k+1, calculate(result, num[k+1], idx));
            operator[idx]++;
        }
    }

    public static void main(String[] args) {
        input();
        pro(0, num[0]);
        System.out.println(max);
        System.out.println(min);
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

