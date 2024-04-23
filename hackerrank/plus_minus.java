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
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    static DecimalFormat df = new DecimalFormat("#.######");
    
    public static void plusMinus(List<Integer> arr) {
        double size = (double) arr.size();
        double positive = 0.000000;
        double negative = 0.000000;
        double zero = 0.000000;
        
        for (int i = 0; i < size; i++) {
            if (arr.get(i) > 0) {
                positive++;
            } else if (arr.get(i).equals(0)) {
                zero++;
            } else {
                negative++;
            }
        }
        
        double positiveRatio = positive / size;
        double zeroRatio = zero / size;
        double negativeRatio = negative / size;
        
        System.out.println(df.format(positiveRatio));
        System.out.println(df.format(negativeRatio));
        System.out.println(df.format(zeroRatio));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
