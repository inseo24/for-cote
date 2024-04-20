import java.io.*;

public class bj_9012 {

    public static void main(String[] args) throws IOException {
        final String YES = "YES";
        final String NO = "NO";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                int openBracket = 0;
                char prev = 'c';
                for (char c : br.readLine().toCharArray()) {
                    if (c == '(') {
                        openBracket++;
                    } else if (c == ')') {
                        openBracket--;
                    }
                    prev = c;
                    if (openBracket < 0) break;
                }

                if (openBracket == 0) {
                    bw.write(YES);
                } else {
                    bw.write(NO);
                }
                bw.newLine();
            }

            bw.flush();
        }
    }
}
