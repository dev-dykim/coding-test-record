import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;

    static void input() {
        N = scan.nextInt();
    }

    static void pro() {
        int answer = 0;
        int[] change = {500, 100, 50, 10, 5, 1};
        int money = 1000 - N;

        for (int n : change) {
            answer += money / n;
            money %= n;
            if (money == 0)
                break;
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(this.st == null || !this.st.hasMoreElements()) {
                try {
                    this.st = new StringTokenizer(this.br.readLine());
                } catch (IOException var2) {
                    var2.printStackTrace();
                }
            }

            return this.st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(this.next());
        }

        long nextLong() {
            return Long.parseLong(this.next());
        }

        double nextDouble() {
            return Double.parseDouble(this.next());
        }

        String nextLine() {
            String str = "";

            try {
                str = this.br.readLine();
            } catch (IOException var3) {
                var3.printStackTrace();
            }

            return str;
        }
    }
}
