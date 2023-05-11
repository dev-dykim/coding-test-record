import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static ArrayList<Integer>[] A;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        A = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for(int i = 1; i <= M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            A[x].add(y);
            A[y].add(x);
        }
        for(int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }
        visit = new boolean[N+1];
    }

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');
        for(int y : A[x]) {
            if(visit[y]) continue;
            dfs(y);
        }
    }

    static void bfs(int start) {
        Queue<Integer> Q = new LinkedList<>();
        visit[start] = true;
        Q.add(start);

        while(!Q.isEmpty()) {
            int x = Q.poll();
            sb.append(x).append(' ');
            for(int y : A[x]) {
                if(visit[y]) continue;
                Q.add(y);
                visit[y] = true;
            }
        }
    }

    static void pro() {
        dfs(V);
        sb.append('\n');
        for(int i = 1; i <= N; i++) {
            visit[i] = false;
        }
        bfs(V);
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

        String next() {
            while(st==null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        Integer nextInt() {
            return Integer.parseInt(next());
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
