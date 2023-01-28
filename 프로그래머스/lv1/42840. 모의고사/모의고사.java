import java.util.Arrays;

class Student implements Comparable<Student>{
    int studentNo;
    int[] ans;
    int score;

    public Student(int studentNo, int[] ans) {
        this.studentNo = studentNo;
        this.ans = ans;
    }

    @Override
    public int compareTo(Student s) {
        return s.score - this.score;
    }
}

class Solution {
    public int[] solution(int[] answers) {
        Student[] students = new Student[3];
        students[0] = new Student(1, new int[] {1, 2, 3, 4, 5});
        students[1] = new Student(2, new int[] {2, 1, 2, 3, 2, 4, 2, 5});
        students[2] = new Student(3, new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        for (int i = 0; i < answers.length; i++) {
            for (Student s : students) {
                if (answers[i] == s.ans[i % (s.ans.length)])
                    s.score++;
            }
        }

        Arrays.sort(students);
        if (students[0].score == students[1].score) {
            if (students[1].score == students[2].score) {
                return new int[]{students[0].studentNo, students[1].studentNo, students[2].studentNo};
            }
            return new int[]{students[0].studentNo, students[1].studentNo};
        }
        return new int[] {students[0].studentNo};
    }
}
