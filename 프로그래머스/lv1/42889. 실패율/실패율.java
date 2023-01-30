import java.util.*;

class FailInfo implements Comparable<FailInfo> {
    int stage;
    double fail;

    public FailInfo(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }

    @Override
    public int compareTo(FailInfo o) {
        if (this.fail == o.fail)
            return this.stage - o.stage;
        if (this.fail < o.fail) return 1;
        else return -1;
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        FailInfo[] failInfos = new FailInfo[N];

        for (int idx = 1; idx <= N; idx++) {
            int trying = 0;
            int tryOrPass = 0;
            for (int i = 0; i < stages.length; i++) {
                if (stages[i] == idx) {
                    trying++;
                    tryOrPass++;
                }

                if(stages[i] > idx)
                    tryOrPass++;

            }

            // tryOrPass 가 0 이면 실패율은 0.0
            double failRate = tryOrPass == 0 ? 0.0 : (double) trying / tryOrPass;
            failInfos[idx-1] = new FailInfo(idx, failRate);
        }

        Arrays.sort(failInfos);
        int index = 0;
        for (FailInfo f : failInfos) {
            answer[index++] = f.stage;
        }

        return answer;
    }
}
