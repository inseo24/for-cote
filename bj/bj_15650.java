import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15650
class bj_15650 {
    static List<List<Integer>> combinations = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            arr = new int[N];
            for (int i = 1; i <= N; i++) {
                arr[i-1] = i;
            }

            combination(N, M, 0, new LinkedList<Integer>());

            for (List<Integer> combination: combinations) {
                for (Integer integer : combination) {
                    bw.write(String.valueOf(integer) + " ");
                }
                bw.newLine();
            }

            bw.flush();
        }
    }

    private static void combination(int n, int r, int next, LinkedList<Integer> temp) {
        if (r == 0) {
            combinations.add(new ArrayList<>(temp));
            return;
        }

        if (next >= n) return;

        temp.add(arr[next]);
        combination(n, r - 1, next + 1, temp);

        temp.pollLast();
        combination(n, r, next + 1, temp);
    }
}