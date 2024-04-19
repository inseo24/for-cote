import java.io.*;

public class bj_1439 {

    public static void main(String[] args) throws IOException {
        // 연속된 0의 집합, 1의 집합의 개수를 구하고 둘 중 작은 수를 리턴
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int[] answer = new int[2];

            String[] nums = br.readLine().split("");

            int prev = 0;
            if (nums != null && nums.length > 0) {
                prev = Integer.parseInt(nums[0]);
            } else {
                return;
            }

            for (String num : nums) {
                int element = Integer.parseInt(num);
                if (prev != element) {
                    answer[prev]++;
                    prev = element;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(Math.max(answer[0], answer[1]));
            bw.write(sb.toString());
            bw.flush();
        }
    }
}
