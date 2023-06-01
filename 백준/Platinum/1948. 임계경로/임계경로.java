import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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

    static int N, M, start, end, answer;
    static ArrayList<Node>[] adj, adjRev;
    static int[] degree, degreeRev;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N+1];
        adjRev = new ArrayList[N+1];
        degree = new int[N+1];
        degreeRev = new int[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            adjRev[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            int to = scan.nextInt();
            int from = scan.nextInt();
            int d = scan.nextInt();
            adj[to].add(new Node(from, d));
            adjRev[from].add(new Node(to, d));
            degree[from]++;
            degreeRev[to]++;
        }

        start = scan.nextInt();
        end = scan.nextInt();
    }

    static void pro() {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                Q.add(i);
            }
        }

        int[] dist = new int[N+1];
        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (Node y : adj[x]) {
                degree[y.targetNode]--;
                dist[y.targetNode] = Math.max(dist[y.targetNode], dist[x] + y.value);
                if (degree[y.targetNode] == 0) {
                    Q.add(y.targetNode);
                }
            }
        }

        visit = new boolean[N+1];
        Q.add(end);
        visit[end] = true;

        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (Node y : adjRev[x]) {
                if (dist[y.targetNode] + y.value == dist[x]) {
                    answer++;
                    if (!visit[y.targetNode]) {
                        visit[y.targetNode] = true;
                        Q.add(y.targetNode);
                    }
                }
            }
        }

        System.out.println(dist[end]);
        System.out.println(answer);
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
