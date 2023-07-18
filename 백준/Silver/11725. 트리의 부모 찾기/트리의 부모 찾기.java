import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[] parent;

    static void input() {
        N = scan.nextInt();
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }

        visit = new boolean[N+1];
        parent = new int[N+1];
    }

    static void pro() {
        dfs(1);

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int now) {
        visit[now] = true;

        for (int next : adj[now]) {
            if (visit[next]) continue;
            parent[next] = now;
            visit[next] = true;
            dfs(next);
        }
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
