import java.io.*;

public class bj_10799 {
    public static void main(String[] args) throws IOException {
        // 현재 문자가 '('면 openCount++
        // 현재 문자가 ')'인 경우,
        //   - 이전 문자가 '('인 경우는 레이저 쏘는 부분이라, 레이저로 잘린 쇠막대기 개수를 answer에 더해줘야함(openCount-- 후 answer에 더함)
        //   - 이전 문자가 ')'인 경우, 쇠막대기의 끝부분이므로 +1 해줘야 함

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String brackets = br.readLine();
            int openCount = 0;
            int answer = 0;
            char prev = '\0';


            for (char current : brackets.toCharArray()) {
                if (current == '(') {
                    openCount++;
                } else if (current == ')') {
                    if (prev == '(') {
                        openCount--;
                        answer += openCount;
                    } else if (prev == ')' && openCount > 0) {
                        openCount--;
                        answer++;
                    }
                }
                prev = current;
            }

            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }
}
