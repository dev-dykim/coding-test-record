import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static boolean arrive;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
        }

        if (arrive)
            System.out.println(1);
        else
            System.out.println(0);
    }

    static void dfs(int num, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visit[num] = true;
        for (int x : adj[num]) {
            if (visit[x]) continue;

            dfs(x, depth + 1);
        }
        
        visit[num] = false;
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

