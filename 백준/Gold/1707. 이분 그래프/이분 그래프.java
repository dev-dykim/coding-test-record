import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int V, E;
    static boolean[] visit;
    static int[] check;
    static boolean isEven;
    static ArrayList<Integer>[] adj;

    static void input() {
        V = scan.nextInt();
        E = scan.nextInt();
        adj = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }

        visit = new boolean[V + 1];
        check = new int[V + 1];
    }

    static void pro() {
        isEven = true;
        for (int i = 1; i <= V; i++) {
            if (isEven) {
                dfs(i);
            } else break;
        }

        if (isEven)
            sb.append("YES").append('\n');
        else
            sb.append("NO").append('\n');
    }

    private static void dfs(int x) {
        visit[x] = true;
        for (int y : adj[x]) {
            if (!visit[y]) {
                check[y] = (check[x] + 1) % 2;
                dfs(y);
            } else if (check[x] == check[y]) {
                isEven = false;
            }
        }
    }

    public static void main(String[] args) {
        int K = scan.nextInt();
        while (K > 0) {
            input();
            pro();
            K--;
        }
        System.out.println(sb.toString());
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
