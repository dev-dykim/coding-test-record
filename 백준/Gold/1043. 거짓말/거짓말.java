import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    static int[] parent, truth;
    static boolean[] answer;
    static ArrayList<Integer>[] party;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();

        truth = new int[K+1];
        for (int i = 1; i <= K; i++) {
            truth[i] = scan.nextInt();
        }

        parent = new int[N+1];
        answer = new boolean[M+1];
        party = new ArrayList[M+1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            answer[i] = true;
            party[i] = new ArrayList<>();
            int num = scan.nextInt();
            for (int j = 1; j <= num; j++) {
                party[i].add(scan.nextInt());
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= M; i++) {
            if (party[i].size() == 1) continue;
            int a = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(a, party[i].get(j));
            }
        }

        for (int i = 1; i <= K; i++) {
            truth[i] = find(truth[i]);
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= K; j++) {
                if (find(parent[party[i].get(0)]) == truth[j]) {
                    answer[i] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= M; i++) {
            if (answer[i]) cnt++;
        }

        System.out.println(cnt);
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
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
