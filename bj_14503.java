import java.io.*;

public class bj_14503 {
    static int count = 0;
    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북, 동, 남, 서


    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {

            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);

            String[] xyd = br.readLine().split(" ");

            // 로봇 청소기의 현재 위치(x, y)
            int x = Integer.parseInt(xyd[0]);
            int y = Integer.parseInt(xyd[1]);

            // 로봇 청소기의 방향(0: 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽)
            int d = Integer.parseInt(xyd[2]);

            int[][] room = new int[m][n];

            for (int i = 0; i < m; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    room[i][j] = Integer.parseInt(row[j]);
                }
            }

            cleanCount(room, x, y, d);
            bw.write(String.valueOf(count));
            bw.flush();
        }
    }

    private static void cleanCount(int[][] room, int x, int y, int direction) {
        // 현재 칸이 아직 청소되지 않은 경우, 현재 칸 청소
        if (room[x][y] == 0) {
            count++;
            room[x][y] = 2; // 청소한 칸은 2로 표시
        }

        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4; // 반시계 방향으로 회전
            int nx = x + directions[direction][0];
            int ny = y + directions[direction][1];

            if (nx >= 0 && nx < room.length && ny >= 0 && ny < room[0].length && room[nx][ny] == 0) {
                cleanCount(room, nx, ny, direction);
                return;
            }
        }

        // 네 방향 모두 청소가 되어있거나 벽인 경우
        int backDirection = (direction + 2) % 4; // 후진 방향
        int bx = x + directions[backDirection][0];
        int by = y + directions[backDirection][1];

        if (bx >= 0 && bx < room.length && by >= 0 && by < room[0].length && room[bx][by] != 1) {
            cleanCount(room, bx, by, direction);
        }
    }
}
