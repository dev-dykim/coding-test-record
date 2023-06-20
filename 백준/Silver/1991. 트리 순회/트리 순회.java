import java.io.*;
import java.util.StringTokenizer;

class Node {
    int left;
    int right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Node[] tree;

    static void input() {
        N = scan.nextInt();
        tree = new Node[N];

        for (int i = 1; i <= N; i++) {
            String str = scan.nextLine();
            String[] strArr = str.split(" ");
            char root = strArr[0].charAt(0);
            char left = strArr[1].charAt(0);
            char right = strArr[2].charAt(0);

            int idx = root - 'A';
            int l = left == '.' ? -1 : left - 'A';
            int r = right == '.' ? -1 : right - 'A';
            tree[idx] = new Node(l, r);
        }
    }

    static void pro() {
        preOrder(0);
        System.out.println(sb.toString());
        sb.setLength(0);
        inOrder(0);
        System.out.println(sb.toString());
        sb.setLength(0);
        postOrder(0);
        System.out.println(sb.toString());
    }

    private static void postOrder(int now) {
        if (now == -1) {
            return;
        }
        postOrder(tree[now].left);
        postOrder(tree[now].right);
        sb.append((char) (now + 'A'));
    }

    private static void inOrder(int now) {
        if (now == -1) {
            return;
        }
        inOrder(tree[now].left);
        sb.append((char) (now + 'A'));
        inOrder(tree[now].right);
    }

    private static void preOrder(int now) {
        if (now == -1) {
            return;
        }
        sb.append((char) (now + 'A'));
        preOrder(tree[now].left);
        preOrder(tree[now].right);
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
