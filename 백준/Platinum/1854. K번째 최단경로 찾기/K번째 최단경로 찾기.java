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

    static int N, M, K;
    static int[][] adj;
    static boolean[] visit;
    static PriorityQueue<Integer>[] dist;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        adj = new int[N+1][N+1];
        visit = new boolean[N+1];
        dist = new PriorityQueue[N+1];
        for (int i = 1; i <= N; i++) {
            dist[i] = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        }

        for (int i = 1; i <= M; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int value = scan.nextInt();
            adj[from][to] = value;
        }
    }

    static void pro() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(((o1, o2) -> o1.value - o2.value));
        pq.add(new Edge(1, 0));
        dist[1].add(0);

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int now = e.to;
            int value = e.value;
            for (int next = 1; next <= N; next++) {
                if (adj[now][next] == 0) continue;
                if (dist[next].size() < K) {
                    dist[next].add(adj[now][next] + value);
                    pq.add(new Edge(next, adj[now][next] + value));
                } else if (dist[next].peek() > adj[now][next] + value) {
                    dist[next].poll();
                    dist[next].add(adj[now][next] + value);
                    pq.add(new Edge(next, adj[now][next] + value));
                }
            }
//            for (Edge e : adj[now]) {
//                int next = e.to;
//                int value = e.value;
//                if (dist[next].size() <= K) {
//                    dist[next].add(dist[now].peek() + value);
//                    pq.add(new Edge(next, dist[next].peek()));
//                } else if (dist[next].peek() > dist[now].peek() + value) {
//                    dist[next].add(dist[now].peek() + value);
//                    pq.add(new Edge(next, dist[next].peek()));
//                }
//            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i].size() == K) {
                sb.append(dist[i].peek()).append('\n');
            } else {
                sb.append(-1).append('\n');
            }
        }

        System.out.println(sb.toString());
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
