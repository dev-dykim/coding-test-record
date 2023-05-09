import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input(){
        N = scan.nextInt();
        A = new int[N+1];
        for(int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static boolean determine(int target_idx) {
        int L = 1, R = N;
        while(L < R) {
            if(target_idx == L) L++;
            else if(target_idx == R) R--;
            else {
                if(A[L] + A[R] == A[target_idx]) return true;
                else if(A[L] + A[R] < A[target_idx]) L++;
                else R--;
            }
        }
        return false;
    }

    static  void pro() {
        Arrays.sort(A, 1, N+1);

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            if(determine(i)) ans++;
        }


        System.out.println(ans);
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
