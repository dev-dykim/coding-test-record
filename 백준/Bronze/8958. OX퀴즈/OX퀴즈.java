import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());  //테스트 케이스 개수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            int score = 0;
            int answer = 0;
            String[] str = s.split("");
            for (String ss : str) {
                if (ss.equals("O"))
                    score++;
                else
                    score = 0;

                answer += score;
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}
