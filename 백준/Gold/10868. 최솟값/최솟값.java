import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] tree;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        int length = N;
        int treeHeight = 0;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        tree = new int[treeSize + 1];
        for (int i = treeSize/2; i < treeSize/2 + N; i++) {
            tree[i] = scan.nextInt();
        }

        setTree(treeSize - 1);

        for (int i = 1; i <= M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int s = treeSize / 2 + a - 1;
            int e = treeSize / 2 + b - 1;
            sb.append(getMin(s, e)).append('\n');
        }

        System.out.println(sb.toString());
    }

    private static int getMin(int s, int e) {
        int min = Integer.MAX_VALUE;
        while (s <= e) {
            if (s % 2 == 1) {
                min = Math.min(min, tree[s++]);
            }
            if (e % 2 == 0) {
                min = Math.min(min, tree[e--]);
            }
            s /= 2;
            e /= 2;
        }
        return min;
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i/2] = Math.min(tree[i], tree[i-1]);
            i -= 2;
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
