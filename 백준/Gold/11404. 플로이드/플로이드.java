import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static long[][] adj;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new long[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    adj[i][j] = 0;
                } else {
                    adj[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i <= M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            long c = scan.nextLong();
            if (adj[a][b] > c) {
                adj[a][b] = c;
            }
        }
    }

    static void pro() {
        for (int k = 1; k <= N; k++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    adj[s][e] = Math.min(adj[s][e], adj[s][k] + adj[k][e]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (adj[i][j] == Integer.MAX_VALUE)
                    sb.append("0 ");
                else
                    sb.append(adj[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
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
