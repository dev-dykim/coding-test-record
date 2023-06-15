import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, erased, root, par;
    static int[] leaf;
    static ArrayList<Integer>[] child;

    static void input() {
        N = scan.nextInt();
        child = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            child[i] = new ArrayList<>();
        }
        for(int i = 0; i < N; i++) {
            int par = scan.nextInt();
            if(par == -1) root = i;
            else child[par].add(i);
        }
        erased = scan.nextInt();
        leaf = new int[N];
    }

    static void dfs(int x, int par) {
        if(child[x].size() == 0) {
            leaf[x]++;
        } else {
            for(int y : child[x]) {
                dfs(y, x);
                leaf[x] += leaf[y];
            }
        }
    }

    static void pro() {
        for(int i = 0; i < N; i++) {
            if(child[i].contains(erased)) {
                child[i].remove(child[i].indexOf(erased));
            }
        }

        if(root != erased) dfs(root, -1);

        System.out.println(leaf[root]);
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
