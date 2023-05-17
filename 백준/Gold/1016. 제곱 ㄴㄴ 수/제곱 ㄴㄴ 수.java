import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static long min;
    static long max;
    static boolean[] check;

    static void input() {
        min = scan.nextLong();
        max = scan.nextLong();
        check = new boolean[(int)(max - min + 1)];
    }
    
    static void pro() {
        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start_index = min / pow;
            if (min % pow != 0)
                start_index++;
            
            for (long j = start_index; pow * j <= max; j++) {
                check[(int) ((j * pow) - min)] = true;
            }
        }
        
        int answer = 0;
        for (boolean c : check) {
            if (!c)
                answer++;
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
