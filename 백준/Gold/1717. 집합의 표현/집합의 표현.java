import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] arr;

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n+1];
        for (int j = 1; j <= n; j++) {
            arr[j] = j;
        }
        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();
            if (x == 0) {
                union(a, b);
            } else {
                if (checkSame(a, b))
                    sb.append("YES").append('\n');
                else
                    sb.append("NO").append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean checkSame(int a, int b) {
        a = found(a);
        b = found(b);
        return a == b;
    }

    private static void union(int a, int b) {
        a = found(a);
        b = found(b);
        if (a != b) {
            arr[b] = a;
        }
    }

    private static int found(int x) {
        if (x == arr[x])
            return x;
        else
            return arr[x] = found(arr[x]);
    }

    public static void main(String[] args) {
        input();
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
