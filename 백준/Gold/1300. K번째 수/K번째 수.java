import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, k;

    static void input() {
        N = scan.nextInt();
        k = scan.nextInt();
    }

    static void pro() {
        int L = 1, R = k;
        int ans = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (findCnt(mid) < k) {
                L = mid + 1;
            } else {
                ans = mid;
                R = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static int findCnt(int x) {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += Math.min(x / i, N);
        }
        return cnt;
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

