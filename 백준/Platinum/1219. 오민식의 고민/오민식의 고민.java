import java.io.*;
import java.util.StringTokenizer;

class Edge {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, start, end;
    static Edge[] edgeArr;
    static long[] dist;
    static long[] money;

    static void input() {
        N = scan.nextInt();
        start = scan.nextInt();
        end = scan.nextInt();
        M = scan.nextInt();

        edgeArr = new Edge[M];
        for (int i = 0; i < M; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            int w = scan.nextInt();
            edgeArr[i] = new Edge(s, e, w);
        }

        money = new long[N];
        for (int i = 0; i < N; i++) {
            money[i] = scan.nextLong();
        }

        dist = new long[N];
        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MIN_VALUE;
        }
        dist[start] = money[start];
    }

    static void pro() {
        for (int i = 0; i < N-1; i++) {
            updateDistance(dist);
        }

        long[] compareDist = new long[N];
        for (int i = 0; i < N; i++) {
            compareDist[i] = dist[i];
        }
        updateDistance(dist);
        checkCycle(compareDist);

        for (int i = 0; i < 100; i++) {
            updateDistance(dist);
        }

        if (dist[end] == Integer.MAX_VALUE)
            System.out.println("Gee");
        else if (dist[end] == Integer.MIN_VALUE)
            System.out.println("gg");
        else
            System.out.println(dist[end]);
    }

    private static void checkCycle(long[] compareDist) {
        for (int i = 0; i < N; i++) {
            if (compareDist[i] != dist[i]) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
    }

    private static void updateDistance(long[] dist) {
        for (int i = 0; i < M; i++) {
            int s = edgeArr[i].start;
            int e = edgeArr[i].end;
            int w = edgeArr[i].weight;
            if (dist[s] == Integer.MIN_VALUE) continue;
            if (dist[s] == Integer.MAX_VALUE) {
                dist[e] = Integer.MAX_VALUE;
            } else {
                dist[e] = Math.max(dist[e], dist[s] + money[e] - w);
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
