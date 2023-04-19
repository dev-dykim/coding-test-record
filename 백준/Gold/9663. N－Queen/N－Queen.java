import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, ans;
    static boolean possible;
    static int[] col;

    static void input() {
        N = scan.nextInt();
        col = new int[N+1];
    }

    static void pro(int r) {
        if (r == N+1) {
            ans++;
            return;
        }

        for (int c = 1; c <= N; c++) {
            possible = true;
            for (int i = 1; i < r; i++) {
                if (attackable(r, c, i, col[i])) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                col[r] = c;
                pro(r+1);
            }
        }
    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if ((r1 - c1) == (r2 - c2)) return true;
        if ((r1 + c1) == (r2 + c2)) return true;
        return false;
    }

    public static void main(String[] args) {
        input();
        pro(1);
        System.out.println(ans);
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

