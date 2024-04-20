import java.io.*;

public class bj_3040 {
    static int[] combination = new int[7];
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int[] nums = new int[9];
            for (int i = 0; i < 9; i++) {
                int num = Integer.parseInt(br.readLine());
                nums[i] = num;
            }

            findCombination(nums, 0, 0);

            for (int num : combination) {
                bw.write(String.valueOf(num));
                bw.newLine();
            }

            bw.flush();
        }
    }

    private static boolean findCombination(int[] nums, int start, int depth) {
        if (depth == 7) {
            int sum = 0;
            for (int num : combination) {
                sum += num;
            }

            if (sum == 100) {
                found = true;
                return true;
            }
            return false;
        }

        for (int i = start; i < nums.length; i++) {
            combination[depth] = nums[i];
            if (findCombination(nums, i + 1, depth + 1)) {
                return true;
            }
        }

        return false;
    }
}