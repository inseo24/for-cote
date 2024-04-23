import java.io.*;

// https://www.acmicpc.net/problem/11403
public class bj_11403 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int n = Integer.parseInt(br.readLine());
            int[][] graph = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(line[j]);
                }
            }

            // i -> k 경로가 존재하고, k -> j 경로가 존재하면, i -> j로 가는 경로가 존재한다.(플루이드-와샬)
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (graph[i][k] == 1 && graph[k][j] == 1) {
                            graph[i][j] = 1;
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    bw.write(graph[i][j] + " ");
                }
                bw.newLine();
            }

            bw.flush();
        }
    }
}
