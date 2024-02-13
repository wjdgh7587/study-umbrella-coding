package baekjoon.step.phase1_4;

import java.util.Scanner;

public class Main_25341 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int intInput = Integer.parseInt(input);

        /**
         *
         * long int -> 4 byte
         * long long int ->8 byte
         *
         * 입력받은 수를 4로 나누어 마지막에 int 문자열 하나만 붙임
         */
        String result = "";
        String a = "long";
        String b = "int";
        String c = " ";

        int inputCount = intInput/4;

        for(int i=0; i<inputCount; i++){
            result = result + a + c;
        }

        result = result + b;

        System.out.println(result);
    }
}
