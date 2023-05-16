import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        long A = scan.nextLong();
        long B = scan.nextLong();
        int sqrtB = (int) Math.sqrt(B);
        long[] arr = new long[sqrtB + 1];

        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i] == 0)
                continue;

            for (int  j = i+i; j < arr.length; j += i) {
                arr[j] = 0;
            }
        }

        int answer = 0;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != 0) {

                long x = arr[i];
//                while (arr[i] * x <= B) {
//                    if (arr[i] * x >= A) {
//                        answer++;
//                    }
//                    x *= arr[i];
//                }
                while ((double) arr[i] <= (double) B / (double) x) {
                    if ((double) arr[i] >= (double) A / (double) x) {
                        answer++;
                    }
                    x *= arr[i];
                }
            }
        }

        System.out.println(answer);

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
