import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();

    static int N;
    static long ans;
    static int[] A, tmp;

    static void input() {
        N = scan.nextInt();
        A = new int[N];
        tmp = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void pro() {
        mergeSort(0, N-1);
        System.out.println(ans);
    }

    static void mergeSort(int start, int end) {
        if (end - start < 1) return;

        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid+1, end);

        for (int i = start; i <= end; i++) {
            tmp[i] = A[i];
        }

        int k = start;
        int index1 = start;
        int index2 = mid+1;
        while(index1 <= mid && index2 <= end) {
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                ans += (index2 - k);
                k++; index2++;
            } else {
                A[k++] = tmp[index1++];
            }
        }

        while (index1 <= mid) {
            A[k++] = tmp[index1++];
        }

        while (index2 <= end) {
            A[k++] = tmp[index2++];
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
