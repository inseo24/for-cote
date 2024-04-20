import java.io.*;

// https://www.acmicpc.net/problem/1992
public class bj_1992 {

    // 1. 재귀적으로 4개 영역을 분할
    // 2. 각 영역별로,
    //   - 영역의 모든 픽셀이 동일한 값(0 또는 1)이면 그 값을 압축 결과에 추가
    //   - 영역에 서로 다른 값이 존재하면, 해당 영역을 다시 4개의 영역으로 분할하고 다시 2번 과정 반복
    // 3. 더 이상 분할할 수 없는 1 X 1 크기면 해당 픽셀 값을 압축 결과에 추가
    // 4. 분할된 압축 결과를 괄호로 묶어서 전체 압축 결과로 리턴

    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int n = Integer.parseInt(br.readLine());
            int[][] image = new int[n][n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    image[i][j] = line.charAt(j) - '0';
                }
            }

            String result = compress(0, 0, n, image);
            bw.write(result);
            bw.flush();
        }
    }

    private static String compress(int x, int y, int size, int[][] image) {
        if (size == 1) {
            return String.valueOf(image[x][y]);
        }

        int halfSize = size / 2;
        String topLeft = compress(x, y, halfSize, image);
        String topRight = compress(x, y + halfSize, halfSize, image);
        String bottomLeft = compress(x + halfSize, y, halfSize, image);
        String bottomRight = compress(x + halfSize, y + halfSize, halfSize, image);

        if (topLeft.equals(topRight) && topLeft.equals(bottomLeft) && topLeft.equals(bottomRight) && topLeft.length() == 1) {
            return topLeft;
        } else {
            return "(" + topLeft + topRight + bottomLeft + bottomRight + ")";
        }
    }
}
