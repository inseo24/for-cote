import java.io.*;

// https://www.acmicpc.net/problem/1789
public class bj_1789 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            long S = Long.parseLong(br.readLine());
            long sum = 0L;
            int count = 0;

            for (long i = 1; sum <= S; i++) {
                sum += i;
                count++;
            }

            bw.write(String.valueOf(count - 1));
            bw.flush();
        }
    }
}