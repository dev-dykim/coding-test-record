import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int M = scan.nextInt();
        int N = scan.nextInt();
        int[] A = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            A[i] = i;
        }

        for (int j = 2; j <= Math.sqrt(N); j++) {
            if (A[j] == 0)
                continue;
            for (int i = j + j; i <= N; i = i + j) {
                A[i] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (A[i] != 0)
                sb.append(i).append('\n');
        }

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
