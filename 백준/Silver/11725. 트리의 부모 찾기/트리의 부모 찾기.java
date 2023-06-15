import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] A;
    static int[] ans;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        A = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for(int i = 1; i < N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            A[x].add(y);
            A[y].add(x);
        }
        ans = new int[N+1];
        visit = new boolean[N+1];
    }

    static void dfs(int idx) {
        visit[idx] = true;
        for(int i = 0; i < A[idx].size(); i++) {
            int nidx = A[idx].get(i);
            if(visit[nidx]) continue;
            ans[nidx] = idx;
            dfs(nidx);
        }
    }

    static void pro() {
        dfs(1);
        for(int i = 2; i <= N; i++) {
            System.out.println(ans[i]);
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
