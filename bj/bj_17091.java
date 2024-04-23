import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/17091
// 시간이 1부터 12 사이, 분이 0부터 59 사이인지 확인, 이 범위를 벗어나면 raise IllegalArgumentException
// 0분인 경우 "o' clock"
// 15분, 30분, 45분인 경우 각각 "quarter past", "half past", "quarter to"
// 30분 이전인 경우 "past", 30분 이후인 경우 "to"
// 1분인 경우 "minute", 그 외의 경우 "minutes"
// 시간이 12시를 넘어갈 경우 처리, ex, 11시 45분은 "quarter to twelve"로 표현
public class bj_17091 {
    private static final String[] ONES = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty"};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int hour = Integer.parseInt(br.readLine());
            int minute = Integer.parseInt(br.readLine());

            if (hour < 1 || hour > 12 || minute < 0 || minute >= 60) {
                throw new IllegalArgumentException("시간은 1부터 12시 사이여야 하고, 분은 0부터 59 사이여야 합니다.");
            }

            String result = getTimeInWords(hour, minute);
            bw.write(result);
            bw.flush();
        }
    }

    private static String getTimeInWords(int hour, int minute) {
        if (minute == 0) {
            return ONES[hour] + " o' clock";
        } else if (minute == 15) {
            return "quarter past " + ONES[hour];
        } else if (minute == 30) {
            return "half past " + ONES[hour];
        } else if (minute == 45) {
            return "quarter to " + ONES[(hour % 12) + 1];
        } else if (minute < 30) {
            return getMinuteString(minute) + " past " + ONES[hour];
        } else {
            return getMinuteString(60 - minute) + " to " + ONES[(hour % 12) + 1];
        }
    }

    private static String getMinuteString(int minute) {
        if (minute < 20) {
            return ONES[minute] + (minute == 1 ? " minute" : " minutes");
        } else {
            return TENS[minute / 10] + " " + ONES[minute % 10] + " minutes";
        }
    }
}