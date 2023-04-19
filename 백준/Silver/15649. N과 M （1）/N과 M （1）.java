import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] selected;
    static boolean[] used;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M];
        used = new boolean[N + 1];
    }

    static void rec_func(int k) {
        if (k == M) {
            for (int x : selected) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int cand = 1; cand <= N; cand++) {
            if (used[cand]) continue;
            selected[k] = cand;
            used[cand] = true;
            rec_func(k+1);
            used[cand] = false;
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(0);
        System.out.println(sb.toString());
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
