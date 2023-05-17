import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[2000000];

        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }
    }

    static void pro() {
        for (int i = 2; i <= Math.sqrt(A.length); i++) {
            if (A[i] == 0)
                continue;

            for (int j = i + i; j < A.length; j += i) {
                A[j] = 0;
            }
        }

        int answer = 0;
        for (int i = N; i < A.length; i++) {
            if (A[i] == 0)
                continue;

            if (isPalindrome(A[i])) {
                answer = A[i];
                break;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPalindrome(int x) {
        String a = String.valueOf(x);
        String b = new StringBuilder(a).reverse().toString();
        return a.equals(b);
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
