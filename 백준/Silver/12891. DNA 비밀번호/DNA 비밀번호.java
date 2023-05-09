import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int P, S;
    static String str;
    static int[] acgtArr = new int[4];
    static int[] cntArr = new int[4];

    static void input() {
        S = scan.nextInt();
        P = scan.nextInt();
        str = scan.next();
        for (int i = 0; i < 4; i++) {
            acgtArr[i] = scan.nextInt();
        }
    }

    static void pro() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int ans = 0;
        int L = 0, R = P-1;
        for (int i = L; i <= R; i++) {
            cntArr[map.get(str.charAt(i))]++;
        }

        if (determine(cntArr, acgtArr)) ans++;

        while (R < S-1) {
            cntArr[map.get(str.charAt(L))]--;
            L++;
            R++;
            cntArr[map.get(str.charAt(R))]++;
            if (determine(cntArr, acgtArr)) ans++;
        }

        System.out.println(ans);
    }

    static boolean determine(int[] cntArr, int[] acgtArr) {
        for (int i = 0; i < 4; i++) {
            if (cntArr[i] < acgtArr[i]) return false;
        }
        return true;
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
