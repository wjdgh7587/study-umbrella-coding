package baekjoon.step.phase1_4;

import java.util.Scanner;

public class Main_18108 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int inputNumber = sc.nextInt();

        /***
         * 불기 연도를 서기 연도로 변환한 결과를 출력한다.
         * 불기년도 = 현년 + 544
         * 따라서 현년 = 불기년도 - 544 (-1 해당년도가 포함이기때문에)
         * */

        int result = inputNumber - 543;

        System.out.println(result);

    }
}
