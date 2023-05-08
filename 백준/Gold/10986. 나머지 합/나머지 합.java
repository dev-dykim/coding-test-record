import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static long[] nums, sums;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        nums = new long[N+1];
        sums = new long[N+1];

        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
            sums[i] = sums[i-1] + nums[i];
        }
    }

    static void pro() {
        long answer = 0;
        long[] remainders = new long[N+1];
        long[] countArr = new long[M];
        for (int i = 1; i <= N; i++) {
            remainders[i] = sums[i] % M;
            if (remainders[i] == 0)
                answer++;
            countArr[(int)remainders[i]]++;
        }

        for (int i = 0; i < M; i++) {
            if (countArr[i] > 1) {
                answer += (countArr[i] * (countArr[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
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
