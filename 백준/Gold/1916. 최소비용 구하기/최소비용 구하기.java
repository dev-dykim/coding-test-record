import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
    int to;
    int value;

    public Edge(int to, int value) {
        this.to = to;
        this.value = value;
    }
}

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, start, end;
    static ArrayList<Edge>[] adj;
    static boolean[] visit;
    static int[] dist;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        visit = new boolean[N+1];
        dist = new int[N+1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int value = scan.nextInt();
            adj[from].add(new Edge(to, value));
        }

        start = scan.nextInt();
        end = scan.nextInt();
    }

    static void pro() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(((o1, o2) -> o1.value - o2.value));
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int now = pq.poll().to;
            if (visit[now]) continue;
            visit[now] = true;

            for (Edge e : adj[now]) {
                int next = e.to;
                int value = e.value;
                if (dist[next] > dist[now] + value) {
                    dist[next] = dist[now] + value;
                    pq.add(new Edge(next, dist[next]));
                }
            }
        }

        System.out.println(dist[end]);
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
