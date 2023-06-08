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

    static int N, M;
    static Edge[] edgeList;
    static long[] dist;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        edgeList = new Edge[M+1];
        dist = new long[N+1];

        for (int i = 1; i <= M; i++) {
            int A = scan.nextInt();
            int B = scan.nextInt();
            int C = scan.nextInt();
            edgeList[i] = new Edge(A, B, C);
        }

        dist[1] = 0;
        for (int i = 2; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
    }

    static void pro() {
        for (int i = 1; i <= N-1; i++) {
            updateDistance();
        }

        long[] lastDist = new long[N+1];
        for (int i = 1; i <= N; i++) {
            lastDist[i] = dist[i];
        }
        updateDistance();

        for (int i = 2; i <= N; i++) {
            if (lastDist[i] != dist[i]) {
                System.out.println(-1);
                return;
            }

            if (dist[i] == Integer.MAX_VALUE) {
                sb.append(-1).append('\n');
            } else {
                sb.append(dist[i]).append('\n');
            }
        }
        
        System.out.print(sb.toString());
    }

    private static void updateDistance() {
        for (int i = 1; i <= M; i++) {
            int S = edgeList[i].start;
            int E = edgeList[i].end;
            int W = edgeList[i].weight;
            if (dist[S] != Integer.MAX_VALUE && dist[E] > dist[S] + W) {
                dist[E] = dist[S] + W;
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
