import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int targetNode;
    int value;

    public Node(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }
}

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int V, E, K;
    static ArrayList<Node>[] adj;
    static boolean[] visit;
    static int[] dist;

    static void input() {
        V = scan.nextInt();
        E = scan.nextInt();
        K = scan.nextInt();

        adj = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        visit = new boolean[V+1];
        dist = new int[V+1];
        for (int i = 1; i <= V; i++) {
            dist[i] = 3000001;
        }

        for (int i = 1; i <= E; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int d = scan.nextInt();
            adj[from].add(new Node(to, d));
        }
    }

    static void pro() {
        dist[K] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.value)));
        pq.add(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visit[now.targetNode]) continue;
            visit[now.targetNode] = true;
            for (Node next : adj[now.targetNode]) {
                if (dist[now.targetNode] + next.value < dist[next.targetNode]) {
                    dist[next.targetNode] = dist[now.targetNode] + next.value;
                    pq.add(new Node(next.targetNode, dist[next.targetNode]));
                }
            }
        }

        for (int i = 1 ; i <= V; i++) {
            if (visit[i])
                System.out.println(dist[i]);
            else
                System.out.println("INF");
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
