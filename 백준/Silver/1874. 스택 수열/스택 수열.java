import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;

    static void input() {
        N = scan.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void pro() {
        int start = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (stack.isEmpty() || stack.peek() < arr[i]) {
                for ( ; start <= arr[i]; start++) {
                    stack.add(start);
                    sb.append('+').append('\n');
                }
            } else if (stack.peek() > arr[i]) {
                System.out.println("NO");
                return;
            }
            if (stack.peek() == arr[i]) {
                stack.pop();
                sb.append('-').append('\n');
            }
        }
        System.out.println(sb.toString());
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

