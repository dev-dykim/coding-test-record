import java.io.*;
import java.util.*;


class Student implements Comparable<Student>{
    String name;
    int koreanScore;
    int englishScore;
    int mathScore;

    public Student(String name, int koreanScore, int englishScore, int mathScore) {
        this.name = name;
        this.koreanScore = koreanScore;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }


    @Override
    public int compareTo(Student s) {
        if (this.koreanScore != s.koreanScore) {
            return s.koreanScore - this.koreanScore;
        } else if (this.englishScore != s.englishScore) {
            return this.englishScore - s.englishScore;
        } else if (this.mathScore != s.mathScore) {
            return s.mathScore - this.mathScore;
        } else {
            return this.name.compareTo(s.name);
        }
    }
}

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Student[] students;

    static void input() {
        N = scan.nextInt();
        students = new Student[N];

        for (int i = 0 ; i < N; i++) {
            String name = scan.next();
            int koreanScore = scan.nextInt();
            int englishScore = scan.nextInt();
            int mathScore = scan.nextInt();
            students[i] = new Student(name, koreanScore, englishScore, mathScore);
        }
    }

    static void pro() {
        Arrays.sort(students);
        for (Student s : students) {
            sb.append(s.name).append('\n');
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
