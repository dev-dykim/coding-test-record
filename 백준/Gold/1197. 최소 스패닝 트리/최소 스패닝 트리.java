import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int start;
    int end;
    int value;

    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int V, E;
    static PriorityQueue<Edge> edges;
    static int[] parent;

    static void input() {
        V = scan.nextInt();
        E = scan.nextInt();
        edges = new PriorityQueue<>();
        parent = new int[V+1];

        for (int i = 0; i < E; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            int v = scan.nextInt();
            edges.add(new Edge(s, e, v));
        }

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
    }

    static void pro() {
        int ans = 0;
        int useEdge = 0;
        while (useEdge < V - 1) {
            Edge edge = edges.poll();
            int s = edge.start;
            int e = edge.end;
            if (find(s) != find(e)) {
                union(s, e);
                ans += edge.value;
                useEdge++;
            }
        }

        System.out.println(ans);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
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
