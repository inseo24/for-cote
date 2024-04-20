import java.io.*;

// https://www.acmicpc.net/problem/2447
public class bj_2447 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            boolean[][] arr = new boolean[n][n];

            // 배열 전체를 true로 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = true;
                }
            }

            // isEmpty 함수를 사용하여 가운데 값을 false로 설정
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isEmpty(i, j, n)) {
                        arr[i][j] = false;
                    }
                }
            }

            // 배열을 기반으로 별 출력
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j]) {
                        bw.write("*");
                    } else {
                        bw.write(" ");
                    }
                }
                bw.newLine();
            }

            bw.flush();
        }
    }

    private static boolean isEmpty(int x, int y, int size) {
        if (size == 1) {
            return false;
        }

        int subSize = size / 3;
        int subX = x / subSize;
        int subY = y / subSize;

        if (subX == 1 && subY == 1) {
            return true;
        }

        return isEmpty(x % subSize, y % subSize, subSize);
    }
}