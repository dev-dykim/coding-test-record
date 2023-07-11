import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    static long[] tree;
    static int MOD = 1000000007;

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
        
        for (int i = 0; i < tree.length; i++) {
            tree[i] = 1;
        }

        for (int i = treeSize / 2; i < treeSize / 2 + N; i++) {
            tree[i] = scan.nextLong();
        }

        setTree(treeSize - 1);

        for (int i = 1; i <= M + K; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            long c = scan.nextLong();

            if (a == 1) {
                int index = treeSize/2 + b - 1;
                long val = c;
                changeVal(index, val);
            } else if (a == 2) {
                int s = treeSize/2 + b - 1;
                int e = treeSize/2 + (int)c - 1;
                sb.append(getMul(s, e)).append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    private static long getMul(int s, int e) {
        long partMul = 1;
        while (s <= e) {
            if (s % 2 == 1) {
                partMul *= tree[s++];
                partMul %= 1000000007;
            }
            if (e % 2 == 0) {
                partMul *= tree[e--];
                partMul %= 1000000007;
            }
            s /= 2;
            e /= 2;
        }
        return partMul;
    }

    private static void changeVal(int index, long val) {
        tree[index] = val;
        while (index > 1) {
            index /= 2;
            tree[index] = tree[index * 2] % 1000000007 * tree[index*2 + 1] % 1000000007;
        }
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i/2] *= tree[i];
            tree[i/2] %= 1000000007;
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
