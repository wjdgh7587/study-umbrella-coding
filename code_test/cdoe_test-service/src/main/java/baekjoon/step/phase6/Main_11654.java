package baekjoon.step.phase6;

import java.util.Scanner;

public class Main_11654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 만약에 여러변수면 ch 단일이면 그냥 ch2
        //char[] ch = sc.nextLine().toCharArray();
        char ch2 = sc.nextLine().charAt(0);
        int parsingChar = ch2;

        System.out.println(parsingChar);
    }
}
