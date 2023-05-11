import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static void input() {
        N = scan.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(A);

        for (int i = 0; i < M; i++) {
            if (binarySearch(B[i]))
                sb.append(1).append('\n');
            else
                sb.append(0).append('\n');
        }

        System.out.println(sb.toString());
    }

    static boolean binarySearch(int x) {
        int L = 0, R = A.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] == x)
                return true;
            else if (A[mid] > x)
                R = mid - 1;
            else
                L = mid + 1;
        }
        return false;
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
