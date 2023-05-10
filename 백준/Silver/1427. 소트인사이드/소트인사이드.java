import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input() {
        String str = scan.next();
        N = str.length();
        A = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            A[i] = str.charAt(i) - '0';
        }
    }

    static void pro() {
        for (int index = 0; index < N; index++) {
            int max = Integer.MIN_VALUE;
            int max_index = 0;
            for (int i = index; i < N; i++) {
                if (max < A[i]) {
                    max = A[i];
                    max_index = i;
                }
            }
            int temp = A[index];
            A[index] = A[max_index];
            A[max_index] = temp;
        }

        for (int num : A) {
            sb.append(num);
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

