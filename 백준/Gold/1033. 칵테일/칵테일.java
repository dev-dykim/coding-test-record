import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static class Data {
        int num;
        int a;
        int b;

        public Data(int num, int a, int b) {
            this.num = num;
            this.a = a;
            this.b = b;
        }
    }

    static int N;
    static long lcm = 1;
    static ArrayList<Data>[] arr;
    static long[] D;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        D = new long[N];
        visit = new boolean[N];
        arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<Data>();
        }

        for (int i = 0; i < N-1; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();
            arr[x].add(new Data(y, a, b));
            arr[y].add(new Data(x, b, a));
            lcm *= ((a * b) / gcd(a, b));
        }

        D[0] = lcm;
    }

    static void pro() {
        dfs(0);
        long totalGcd = D[0];
        for (int i = 1; i < N; i++) {
            totalGcd = gcd(totalGcd, D[i]);
        }

        for (long d : D) {
            sb.append(d / totalGcd).append(' ');
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int x) {
        visit[x] = true;
        for (Data d : arr[x]) {
            int y = d.num;
            if (!visit[y]) {
                D[y] = D[x] * d.b / d.a;
                dfs(y);
            }
        }
    }

    private static long gcd(long a, long b) {
        if (a % b == 0)
            return b;

        return gcd(b, a % b);
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
