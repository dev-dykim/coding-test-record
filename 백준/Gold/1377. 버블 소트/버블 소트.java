import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Data implements Comparable<Data>{
        public int index;
        public int value;

        public Data(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Data d) {
            return this.value - d.value;
        }
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Data[] arr;

    static void input() {
        N = scan.nextInt();
        arr = new Data[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new Data(i, scan.nextInt());
        }
    }

    static void pro() {
        Arrays.sort(arr, 1, N+1);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, arr[i].index - i);
        }

        System.out.println(max + 1);
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

