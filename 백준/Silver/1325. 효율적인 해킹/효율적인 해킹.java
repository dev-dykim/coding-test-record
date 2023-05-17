import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] dist;
    static boolean[] visit;
    static ArrayList<Integer>[] adj;
    static int[] answer;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
        }
    }

    static void pro() {
        answer = new int[N+1];
        for (int i = 1; i <= N; i++) {
            dist = new int[N+1];
            visit = new boolean[N+1];
            bfs(i);
        }

        int max = Integer.MIN_VALUE;
//        for (int i = 1; i <= N; i++) {
//            if (max < dist[i]) {
//                sb.setLength(0);
//                sb.append(i).append(' ');
//                max = dist[i];
//            } else if (max == dist[i]) {
//                sb.append(i).append(' ');
//            }
//        }
        
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, answer[i]);
        }
        for (int i = 1; i <= N; i++) {
            if (answer[i] == max) {
                sb.append(i).append(' ');
            }
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visit[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : adj[x]) {
               if (!visit[y]) {
                   dist[y] = dist[x] + 1;
                   visit[y] = true;
                   answer[y]++;
                   q.add(y);
               }
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
