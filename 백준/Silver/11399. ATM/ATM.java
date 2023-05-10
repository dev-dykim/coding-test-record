import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void pro() {
//        for (int i = 1; i < N; i++) {
//            int insert_value = A[i];
//            int insert_point = findIndex(insert_value, i);
//            for (int j = i; j > insert_point; j--) {
//                A[j] = A[j-1];
//            }
//            A[insert_point] = insert_value;
//
//        }

        Arrays.sort(A);
        
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += A[i] * (N - i);
        }

        System.out.println(ans);
    }

    static int findIndex(int target, int k) {
        int L = 0, R = k;
        int mid = 0;
        while (L <= R) {
            mid = (L + R) / 2;
            if (A[mid] > target) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return mid;

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
