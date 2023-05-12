import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, zero, one;
    static PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> pq2 = new PriorityQueue<>();

    static void input() {
        N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            int x = scan.nextInt();
            if (x == 0) {
                zero++;
            } else if (x == 1) {
                one++;
            } else if (x > 1) {
                pq1.add(x);
            } else {
                pq2.add(x);
            }
        }
    }

    static void pro() {

        int sum = 0;
        while (pq1.size() > 1) {
            int x = pq1.poll();
            int y = pq1.poll();
            sum += x * y;
        }

        if (!pq1.isEmpty()) {
            sum += pq1.poll();
        }

        while (pq2.size() > 1) {
            int x = pq2.poll();
            int y = pq2.poll();
            sum += x * y;
        }

        if (!pq2.isEmpty()) {
            if (zero == 0) {
                sum += pq2.poll();
            }
        }

        sum += one;

        System.out.println(sum);

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

