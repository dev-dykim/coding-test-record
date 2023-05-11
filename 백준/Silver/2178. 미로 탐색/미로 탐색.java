import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] A;
    static boolean[][] visit;
    static int[][] dist;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N];
        for(int i = 0; i < N; i++) {
            A[i] = scan.nextLine();
        }
        visit = new boolean[N][M];
        dist = new int[N][M];
    }

    static void bfs(int x, int y) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        visit[x][y] = true;
        dist[x][y] = 1;

        while(!Q.isEmpty()) {
            x = Q.poll();
            y = Q.poll();
            for(int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(A[nx].charAt(ny) == '0') continue;
                if(visit[nx][ny]) continue;
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() {
        bfs(0, 0);
        System.out.println(dist[N-1][M-1]);
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
            while( st==null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        String nextLine(){
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
