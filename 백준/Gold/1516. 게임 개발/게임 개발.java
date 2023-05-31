import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] adj;
    static int[] degree, minutes, answer;

    static void input() {
        N = scan.nextInt();
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        degree = new int[N+1];
        minutes = new int[N+1];
        answer = new int[N+1];

        for (int i = 1; i <= N; i++) {
            minutes[i] = scan.nextInt();
            int x = scan.nextInt();
            while (x != -1) {
                adj[x].add(i);
                degree[i]++;
                x = scan.nextInt();
            }
        }
    }

    static void pro() {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0)
                Q.add(i);
        }

        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (int y : adj[x]) {
                degree[y]--;
                answer[y] = Math.max(answer[y], answer[x] + minutes[x]);
                if (degree[y] == 0) {
                    Q.add(y);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            answer[i] += minutes[i];
            sb.append(answer[i]).append('\n');
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
