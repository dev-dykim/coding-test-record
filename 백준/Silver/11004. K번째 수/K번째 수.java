import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void pro() {
//        Arrays.sort(A);
        quickSort(0, N-1);

        System.out.println(A[K-1]);
    }

    static void quickSort(int start, int end) {
        if (start < end) {
            int pivot = partition(start, end);
            if (pivot == K-1)
                return;
            else if (pivot > K-1)
                quickSort(start, pivot - 1);
            else
                quickSort(pivot + 1, end);
        }
    }

    static int partition(int start, int end) {

        if (start + 1 == end) {
            if (A[start] > A[end])
                swap(start, end);
            return end;
        }

        int mid = (start + end) / 2;
        swap(start, mid);
        int pivot = A[start];
        int i = start + 1, j = end;
        while (i <= j) {
            while (pivot > A[i] && i < N-1) i++;
            while (pivot < A[j] && j > 0) j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        A[start] = A[j];
        A[j] = pivot;
        return j;
    }

    static void swap(int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
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

