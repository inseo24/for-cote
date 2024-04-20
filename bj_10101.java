import java.io.*;

public class bj_10101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int angle1 = Integer.parseInt(br.readLine());
        int angle2 = Integer.parseInt(br.readLine());
        int angle3 = Integer.parseInt(br.readLine());

        if (angle1 == 60 && angle2 == 60 && angle3 == 60) { // 정삼각형
            System.out.println("Equilateral");
        } else if (angle1 + angle2 + angle3 == 180) {
            if (angle1 == angle2 || angle1 == angle3 || angle2 == angle3) {
                System.out.println("Isosceles"); // 이등변삼각형
            } else {
                System.out.println("Scalene"); // 부등변삼각형(이등변삼각형이 아닌 삼각형)
            }
        } else {
            System.out.println("Error");
        }
    }
}
