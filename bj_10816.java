import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj_10816 {
    public static void main(String[] args) throws Exception {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int[] count = new int[20000001]; // 입력 범위: -10,000,000 ~ 10,000,000

            int n = Integer.parseInt(bufferedReader.readLine());
            String nList = bufferedReader.readLine();
            String[] card = nList.split(" ");

            for (String c : card) {
                int element = Integer.parseInt(c);
                count[element + 10000000]++; // 음수 인덱스 방지 목적으로 10,000,000 을 더함
            }

            int m = Integer.parseInt(bufferedReader.readLine());
            String mList = bufferedReader.readLine();
            String[] targetList = mList.split(" ");

            StringBuilder stringBuilder = new StringBuilder();

            for (String target: targetList) {
                int element = Integer.parseInt(target);
                stringBuilder.append(count[element + 10000000]).append(" ");
            }

            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        }
    }
}