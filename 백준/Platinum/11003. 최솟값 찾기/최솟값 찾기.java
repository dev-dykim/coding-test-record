import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Data {
    private int index;
    private int value;

    public Data(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, L;
    static int[] arr;

    static void input() {
        N = scan.nextInt();
        L = scan.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void pro() {
        Deque<Data> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            if (i >= L && !deque.isEmpty() && deque.peekFirst().getIndex() <= i - L) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && deque.peekLast().getValue() > arr[i]) {
                deque.pollLast();
            }
            deque.addLast(new Data(i, arr[i]));
            sb.append(deque.peekFirst().getValue()).append(' ');
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
