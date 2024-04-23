import java.io.*;

// https://www.acmicpc.net/problem/15649
// 1부터 N까지 자연수 중에 중복 없이 M개를 고른 수열(순열)
public class bj_15649 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);

            arr = new int[m];
            visited = new boolean[n + 1];

            permutation(0);

            bw.flush();
            bw.close();
        }
    }

    private static void permutation(int depth) throws IOException {
        if (depth == m) {
            for (int num: arr) {
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}
