import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N][2];
        for (int i = 0; i < N; i++) {
            A[i][0] = scan.nextInt();
            A[i][1] = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[1];
                else
                    return o1[1] - o2[1];
            }
        });
        int ans = 1;
        int endTime = A[0][1];
        for (int i = 1; i < N; i++) {
            if (A[i][0] >= endTime) {
                ans++;
                endTime = A[i][1];
            }
        }

        System.out.println(ans);
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
