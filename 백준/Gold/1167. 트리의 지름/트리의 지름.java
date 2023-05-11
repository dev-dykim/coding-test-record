import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    static int V;
    static ArrayList<Node>[] adj;
    static boolean[] visit;
    static int[] dist;

    static void input() {
        V = scan.nextInt();
        adj = new ArrayList[V+1];
        visit = new boolean[V+1];
        dist = new int[V+1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) {
            int v = scan.nextInt();
            int x = scan.nextInt();
            while (x != -1) {
                adj[v].add(new Node(x, scan.nextInt()));
                x = scan.nextInt();
            }
        }
    }

    static void pro() {
        bfs(1);
        int max = 0;
        int maxIndex = 0;
        for (int i = 1; i <= V; i++) {
            if (max < dist[i]) {
                max = dist[i];
                maxIndex = i;
            }
        }

        dist = new int[V+1];
        visit = new boolean[V+1];
        bfs(maxIndex);
        for (int i = 1; i <= V; i++) {
            if (max < dist[i]) {
                max = dist[i];
                maxIndex = i;
            }
        }

        System.out.println(max);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (Node node : adj[x]) {
                if (visit[node.vertex]) continue;
                queue.add(node.vertex);
                visit[node.vertex] = true;
                dist[node.vertex] = dist[x] + node.distance;
            }
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

