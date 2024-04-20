import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

// https://www.acmicpc.net/problem/11651
public class bj_11651 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Map<Integer, Integer>> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String[] newLine = br.readLine().split(" ");
                int x = Integer.parseInt(newLine[0]);
                int y = Integer.parseInt(newLine[1]);

                list.add(Map.of(x, y));
            }

            Collections.sort(list, (map1, map2) -> {
                // list 안의 Map 요소들을 y좌표 기준으로 비교
                int valueCompare = map1.values().iterator().next().compareTo(map2.values().iterator().next());
                if (valueCompare != 0) {
                    return valueCompare;
                } else {
                    // y좌표가 같으면 x좌표를 비교
                    return map1.keySet().iterator().next().compareTo(map2.keySet().iterator().next());
                }
            });

            for (Map<Integer, Integer> map: list) {
                for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                    bw.write(entry.getKey() + " " + entry.getValue());
                }
                bw.newLine();
            }

            bw.flush();
        }
    }
}
