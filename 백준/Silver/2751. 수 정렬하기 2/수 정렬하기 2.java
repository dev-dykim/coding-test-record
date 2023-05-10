import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(A);
//        mergeSort(0, N-1);
        for (int num : A) {
            sb.append(num).append('\n');
        }
        System.out.println(sb.toString());
    }

    static void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid+1, end);

        int[] tmp = new int[N];
        for (int i = start; i <= end; i++) {
            tmp[i] = A[i];
        }

        int k = start;
        int idx1 = start;
        int idx2 = mid + 1;
        while (idx1 <= mid && idx2 <= end) {
            if (tmp[idx1] > tmp[idx2]) {
                A[k++] = tmp[idx2++];
            } else {
                A[k++] = tmp[idx1++];
            }
        }

        while (idx1 <= mid) {
            A[k++] = tmp[idx1++];
        }

        while (idx2 <= end) {
            A[k++] = tmp[idx2++];
        }
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

