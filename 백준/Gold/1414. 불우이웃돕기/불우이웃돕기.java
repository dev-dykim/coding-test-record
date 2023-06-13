import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
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

    static int N, totalSum;
    static int[] parent;
    static PriorityQueue<Edge> edges = new PriorityQueue<>();

    static void input() {
        N = scan.nextInt();
        for (int i = 1; i <= N; i++) {
            String s = scan.next();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == '0') continue;
                else if (s.charAt(j) >= 'a') {
                    edges.add(new Edge(i, j+1, s.charAt(j) - 'a' + 1));
                    totalSum += s.charAt(j) - 'a' + 1;
                } else {
                    edges.add(new Edge(i, j+1, s.charAt(j) - 'A' + 27));
                    totalSum += s.charAt(j) - 'A' + 27;
                }
            }
        }
    }

    static void pro() {
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int edgeSum = 0;
        int edgeCnt = 0;
        while (!edges.isEmpty() && edgeCnt < N-1) {
            Edge now = edges.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                edgeSum += now.value;
                edgeCnt++;
            }
        }

        if (edgeCnt == N-1) {
            System.out.println(totalSum - edgeSum);
        } else {
            System.out.println(-1);
        }

    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (x == parent[x])
            return x;
        else {
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
