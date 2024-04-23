import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        String answer = s.substring(0, 8);
        int h = Integer.parseInt(s.substring(0, 2));
        String ft = s.substring(8, 10);
        
        if (ft.equals("AM")) {
            if (h >= 12) {
                answer = "00:" + s.substring(3, 8);
            }
        } else {
            h += 12;
            if (h > 24) {
                answer = "00:" + s.substring(3, 8);
            } else if (h < 24) {
                answer = h + ":" + s.substring(3, 8);
            }
        }
        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
