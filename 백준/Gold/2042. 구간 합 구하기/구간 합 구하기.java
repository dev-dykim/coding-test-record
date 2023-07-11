import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    static long[] tree;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();

        int treeHeight = 0;
        int length = N;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        tree = new long[treeSize + 1];

        for (int i = treeSize / 2; i < treeSize / 2 + N; i++) {
            tree[i] = scan.nextLong();
        }

        setTree(treeSize - 1);

        for (int i = 1; i <= M + K; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            long c = scan.nextLong();

            if (a == 1) {
                changeVal(treeSize / 2 - 1 + b, c);
            } else if (a == 2) {
                int s = treeSize / 2 - 1 + b;
                int e = treeSize / 2 - 1 + (int) c;
                sb.append(getSum(s, e)).append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    private static long getSum(int s, int e) {
        long partSum = 0;
        while (s <= e) {
            if (s % 2 == 1) {
                partSum += tree[s++];
            }
            if (e % 2 == 0) {
                partSum += tree[e--];
            }
            s /= 2;
            e /= 2;
        }
        return partSum;
    }

    private static void changeVal(int index, long val) {
        long diff = val - tree[index];
        while (index > 0) {
            tree[index] += diff;
            index /= 2;
        }
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i/2] += tree[i];
            i--;
        }
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
